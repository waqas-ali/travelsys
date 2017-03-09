/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.controllers;

import com.crossover.project.dao.OrderJDBCTemplate;
import com.google.gson.Gson;
import com.crossover.project.entities.JqDataTable;
import com.crossover.project.entities.Roles;
import com.crossover.project.entities.SessionEntity;
import com.crossover.project.entities.Order;
import com.crossover.project.helper.AppConfig;
import com.crossover.project.helper.EmailHelper;
import com.crossover.project.response.ControllerResponse;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author waqas.ali2
 */
@Controller
@RequestMapping("/summary")
public class SummaryController {

    private static final Logger LOGGER = Logger.getLogger(SummaryController.class);
    @Autowired
    private OrderJDBCTemplate template;

    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public String homePage() {
        String page = "summary/admin_home";;
        try {
            SessionEntity session = (SessionEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (session.getRole() == Roles.ROLE_ADMIN) {
                page = "summary/admin_home";
            } else if (session.getRole() == Roles.ROLE_USER) {
                page = "summary/user_home";
            }
        } catch (Exception e) {

        }
        return page;
    }

    @RequestMapping(value = "/getAllOrders.htm", method = RequestMethod.GET)
    @ResponseBody
    public JqDataTable getAllOrders() {
        JqDataTable jqDataTable = new JqDataTable();
        try {

            List<Order> orders = template.listOrders();
            LOGGER.info("Getting all Tickets data");

            jqDataTable.setAaData(orders);
            jqDataTable.setDraw(1);
            jqDataTable.setRecordsFiltered(orders.size());
            jqDataTable.setRecordsTotal(orders.size());
            jqDataTable.setiDisplayLength(5);
            jqDataTable.setsEcho(1);

            Gson gson = new Gson();
            String json = gson.toJson(jqDataTable);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return jqDataTable;
    }

    @RequestMapping(value = "/getOrdersByUser.htm", method = RequestMethod.GET)
    @ResponseBody
    public JqDataTable getOrdersByUser() {
        JqDataTable jqDataTable = new JqDataTable();
        try {

            SessionEntity session = (SessionEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            List<Order> orders = template.getOrders(session.getAccountId());
            LOGGER.info("Getting all Tickets data");

            jqDataTable.setAaData(orders);
            jqDataTable.setDraw(1);
            jqDataTable.setRecordsFiltered(orders.size());
            jqDataTable.setRecordsTotal(orders.size());
            jqDataTable.setiDisplayLength(5);
            jqDataTable.setsEcho(1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return jqDataTable;
    }

    @RequestMapping(value = "/downloadSummary.htm", method = RequestMethod.GET)
    public ModelAndView downloadReport() {

        SessionEntity session = (SessionEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Order> orders = template.getOrders(session.getAccountId());

        ModelAndView modelAndView = new ModelAndView("pdfView", "orders", orders);

        return modelAndView;
    }

    @RequestMapping(value = "/emailSummary.htm", method = RequestMethod.POST)
    @ResponseBody
    public ControllerResponse emailReport() {
        ControllerResponse response = new ControllerResponse();
        try {

            SessionEntity session = (SessionEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String email = session.getEmail();
            List<Order> orders = template.getOrders(session.getAccountId());
            EmailHelper.sendEmail(email, orders);
            response.setMessage(AppConfig.getProperty("EMAIL_SENT"));
            response.setStatus(AppConfig.getProperty("SUCCESS"));
        } catch (Exception e) {
            response.setMessage(AppConfig.getProperty("ERROR_OCCURRED"));
            response.setStatus(AppConfig.getProperty("ERROR"));
            LOGGER.error(e.getMessage(), e);
        }
        return response;
    }
}
