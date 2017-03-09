/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.controllers;

import com.crossover.project.dao.UserJDBCTemplate;
import com.crossover.project.entities.Currency;
import com.crossover.project.entities.JqDataTable;
import com.crossover.project.entities.Roles;
import com.crossover.project.entities.SessionEntity;
import com.crossover.project.entities.User;
import com.crossover.project.helper.AppConfig;
import com.crossover.project.helper.EncryptionUtils;
import com.crossover.project.jsonpojo.Account;
import com.crossover.project.jsonpojo.DepositWithdrawRequest;
import com.crossover.project.jsonpojo.MonetaryAmount;
import com.crossover.project.entities.UserRequest;
import com.crossover.project.response.ControllerResponse;
import com.crossover.project.restclient.ForestAPI;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author waqas.ali2
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    private static final Logger LOGGER = Logger.getLogger(BaseController.class);
    @Autowired
    private UserJDBCTemplate template;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login(Model model) {
        return "base/login";
    }

    @RequestMapping(value = "/registerpage.htm", method = RequestMethod.GET)
    public String registerPage(Model model) {
        return "base/register";
    }

    @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
    @ResponseBody
    public ControllerResponse register(@RequestBody UserRequest request, BindingResult error) {

        ControllerResponse response = new ControllerResponse();
        try {
            request.setPassword(EncryptionUtils.convertStringToMD5Hash(request.getPassword()));

            if (Roles.valueOf(request.getRole()) == Roles.ROLE_ADMIN) {
                MonetaryAmount balance = new MonetaryAmount();
                balance.setCurrency(Currency.USD);
                Account account = new Account();
                account.setBalance(balance);

                template.create(request, account);
                response.setMessage(AppConfig.getProperty("REGISTRATION_SUCCESS"));
                response.setStatus(AppConfig.getProperty("SUCCESS"));
            } else {
                ForestAPI apiIntegration = new ForestAPI();

                Account account = apiIntegration.createAccount();
                account.getBalance().setAmount(1000.0);
                DepositWithdrawRequest deposit = new DepositWithdrawRequest();
                deposit.setAccountId(account.getId());
                deposit.setMonetaryAmount(account.getBalance());
                apiIntegration.deposit(deposit);
                template.create(request, account);
                response.setMessage(AppConfig.getProperty("REGISTRATION_SUCCESS"));
                response.setStatus(AppConfig.getProperty("SUCCESS"));
            }
        } catch (DuplicateKeyException e) {
            response.setMessage(AppConfig.getProperty("ALREADY_REGISTERED"));
            response.setStatus(AppConfig.getProperty("ERROR"));
            LOGGER.warn(e.getMessage(), e);
        } catch (HttpClientErrorException e) {
            response.setMessage(AppConfig.getProperty("CONNECTION_PROBLEM"));
            response.setStatus(AppConfig.getProperty("ERROR"));
            LOGGER.warn(e.getMessage(), e);
        } catch (Exception e) {
            response.setMessage(AppConfig.getProperty("ERROR_OCCURRED"));
            response.setStatus(AppConfig.getProperty("ERROR"));
            LOGGER.warn(e.getMessage(), e);
        }
        return response;
    }

    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public String homePage() {
        String page = "admin/home";;
        try {
            SessionEntity session = (SessionEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (session.getRole() == Roles.ROLE_ADMIN) {
                page = "admin/home";
            } else if (session.getRole() == Roles.ROLE_USER) {
                page = "redirect:/offer/home.htm";
            }
        } catch (Exception e) {

        }
        return page;
    }

    @RequestMapping(value = "/loginfailed.htm", method = RequestMethod.GET)
    public String loginFailed(Model model) {
        model.addAttribute("ERR_MSG", AppConfig.getProperty("INVALID_USERNAME_PASSWORD"));
        return "base/login";
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logout(Model model) {
        return "base/login";
    }

    @RequestMapping(value = "/getAllUsers.htm", method = RequestMethod.GET)
    @ResponseBody
    public JqDataTable getAllUsers() {
        JqDataTable jqDataTable = new JqDataTable();
        try {

            List<User> users = template.listUsers();
            LOGGER.info("Getting all Tickets data");

            jqDataTable.setAaData(users);
            jqDataTable.setDraw(1);
            jqDataTable.setRecordsFiltered(users.size());
            jqDataTable.setRecordsTotal(users.size());
            jqDataTable.setiDisplayLength(5);
            jqDataTable.setsEcho(1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return jqDataTable;
    }
}
