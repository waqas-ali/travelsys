/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.controllers;

import com.crossover.project.dao.OrderJDBCTemplate;
import com.crossover.project.response.ControllerResponse;
import com.crossover.project.entities.JqDataTable;
import com.crossover.project.entities.SessionEntity;
import com.crossover.project.helper.AppConfig;
import com.crossover.project.jsonpojo.AirlineOffer;
import com.crossover.project.jsonpojo.AirlineRoute;
import com.crossover.project.jsonpojo.AirlineTicket;
import com.crossover.project.jsonpojo.BuyTicketRequest;
import com.crossover.project.entities.Order;
import com.crossover.project.entities.TicketRequest;
import com.crossover.project.restclient.ForestAPI;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/offer")
public class OfferController {

    private static final Logger LOGGER = Logger.getLogger(OfferController.class);

    @Autowired
    private OrderJDBCTemplate template;
    
    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public String home() {
        return "offer/home";
    }

    @RequestMapping(value = "/getOffers.htm", method = RequestMethod.GET)
    @ResponseBody
    public JqDataTable getOffers() {
        JqDataTable jqDataTable = new JqDataTable();

        try {
            ForestAPI apiIntegration = new ForestAPI();
            List<AirlineOffer> offers = apiIntegration.getOffers();

            jqDataTable.setAaData(offers);
            jqDataTable.setDraw(1);
            jqDataTable.setRecordsFiltered(offers.size());
            jqDataTable.setRecordsTotal(offers.size());
            jqDataTable.setiDisplayLength(5);
            jqDataTable.setsEcho(1);

        } catch (Exception ex) {
            LOGGER.debug(ex.getMessage(),ex);
        }
        return jqDataTable;

    }

    @RequestMapping(value = "/buyTicket.htm", method = RequestMethod.POST)
    @ResponseBody
    public ControllerResponse buyTicket(@RequestBody TicketRequest request) {
        ControllerResponse response = new ControllerResponse();

        try {

            SessionEntity session = (SessionEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            AirlineRoute route = new AirlineRoute();
            route.setFrom(request.getFrom());
            route.setTo(request.getTo());

            BuyTicketRequest buyTicketReq = new BuyTicketRequest();

            buyTicketReq.setAccountId(session.getAccountId());
            buyTicketReq.setAmount(request.getAmount());

            buyTicketReq.setRoute(route);

            ForestAPI apiIntegration = new ForestAPI();
            AirlineTicket ticket = apiIntegration.buyTicket(buyTicketReq);
            Order order = new Order();
            order.setAccountId(session.getAccountId());
            order.setFrom(request.getFrom());
            order.setTo(request.getTo());
            order.setTickets(request.getAmount());
            order.setTotalPrice(request.getAmount()*ticket.getDetails().getPrice().getAmount());
            template.create(order);
            response.setMessage(AppConfig.getProperty("TICKET_PURCHASED"));
            response.setStatus(AppConfig.getProperty("SUCCESS"));
        } catch (HttpClientErrorException e) {
            String respBody = e.getResponseBodyAsString();
            String message = new GsonBuilder().create().fromJson(respBody,JsonObject.class).get("message").getAsString();
            response.setMessage(message);
            response.setStatus(AppConfig.getProperty("ERROR"));
            LOGGER.warn(e.getMessage(), e);
        } catch (Exception ex) {
            response.setMessage(AppConfig.getProperty("ERROR_OCCURRED"));
            response.setStatus(AppConfig.getProperty("ERROR"));
            LOGGER.debug(ex.getMessage(), ex);
        }
        return response;

    }
}
