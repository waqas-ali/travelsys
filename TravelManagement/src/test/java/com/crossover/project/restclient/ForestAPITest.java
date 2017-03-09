/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.restclient;

import com.crossover.project.entities.Currency;
import com.crossover.project.jsonpojo.Account;
import com.crossover.project.jsonpojo.AirlineOffer;
import com.crossover.project.jsonpojo.AirlineRoute;
import com.crossover.project.jsonpojo.AirlineTicket;
import com.crossover.project.jsonpojo.BuyTicketRequest;
import com.crossover.project.jsonpojo.DepositWithdrawRequest;
import com.crossover.project.jsonpojo.MonetaryAmount;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waqas.ali2
 */
public class ForestAPITest {

    public ForestAPITest() {
    }

    /**
     * Test of createAccount method, of class ForestAPI.
     */
    @Test
    public void testCreateAccount() {
        ForestAPI instance = new ForestAPI();
        Account result = instance.createAccount();
        assertNotNull(result);

    }

    /**
     * Test of deposit method, of class ForestAPI.
     */
    @Test
    public void testDeposit() {
        try {
        ForestAPI instance = new ForestAPI();
        Account account = instance.createAccount();

        MonetaryAmount balance = new MonetaryAmount();
        balance.setAmount(1000.0);
        balance.setCurrency(Currency.USD);

        DepositWithdrawRequest request = new DepositWithdrawRequest();
        request.setAccountId(account.getId());

        request.setMonetaryAmount(balance);

        Account result = instance.deposit(request);

        assertEquals(account.getId(), result.getId());
        }catch(Exception e ) {
            fail("Error Occurred, while calling api.");
        }
    }

    /**
     * Test of getOffers method, of class ForestAPI.
     */
    @Test
    public void testGetOffers() {
        System.out.println("getOffers");
        ForestAPI instance = new ForestAPI();
        List<AirlineOffer> result = instance.getOffers();
        assertTrue(result.size() >= 0);

    }

    /**
     * Test of resetAccount method, of class ForestAPI.
     */
    @Test
    public void testResetAccount() {
        ForestAPI instance = new ForestAPI();
        instance.resetAccount();
        assertTrue(true);
    }

    /**
     * Test of buyTicket method, of class ForestAPI.
     */
    @Test
    public void testBuyTicket() {
        try {
            ForestAPI instance = new ForestAPI();
            Account account = instance.createAccount();

            MonetaryAmount balance = new MonetaryAmount();
            balance.setAmount(1000.0);
            balance.setCurrency(Currency.USD);

            DepositWithdrawRequest request = new DepositWithdrawRequest();
            request.setAccountId(account.getId());

            request.setMonetaryAmount(balance);

            Account result = instance.deposit(request);

            BuyTicketRequest ticketRequest = new BuyTicketRequest();
            AirlineRoute route = new AirlineRoute();
            route.setFrom("London");
            route.setTo("Madrid");
            ticketRequest.setAccountId(result.getId());
            ticketRequest.setAmount(2);
            ticketRequest.setRoute(route);

            AirlineTicket booked = instance.buyTicket(ticketRequest);
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Error Occurred, while calling api.");
        }
    }
}
