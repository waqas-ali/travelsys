/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.jsonpojo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waqas.ali2
 */
public class BuyTicketRequestTest {
    
    public BuyTicketRequestTest() {
    }

    /**
     * Test of getAccountId method, of class BuyTicketRequest.
     */
    @Test
    public void testGetAccountId() {
        String expResult = "1234";
        BuyTicketRequest instance = new BuyTicketRequest();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccountId method, of class BuyTicketRequest.
     */
    @Test
    public void testSetAccountId() {
        String expResult = "1234";
        BuyTicketRequest instance = new BuyTicketRequest();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmount method, of class BuyTicketRequest.
     */
    @Test
    public void testGetAmount() {
        long expResult = 30L;
        BuyTicketRequest instance = new BuyTicketRequest();
        instance.setAmount(expResult);
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount method, of class BuyTicketRequest.
     */
    @Test
    public void testSetAmount() {
        long expResult = 30L;
        BuyTicketRequest instance = new BuyTicketRequest();
        instance.setAmount(expResult);
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoute method, of class BuyTicketRequest.
     */
    @Test
    public void testGetRoute() {
        System.out.println("getRoute");
        BuyTicketRequest instance = new BuyTicketRequest();
        instance.setRoute(new AirlineRoute());
        AirlineRoute result = instance.getRoute();
        assertNotNull(result);
    }

    /**
     * Test of setRoute method, of class BuyTicketRequest.
     */
    @Test
    public void testSetRoute() {
        System.out.println("getRoute");
        BuyTicketRequest instance = new BuyTicketRequest();
        instance.setRoute(new AirlineRoute());
        AirlineRoute result = instance.getRoute();
        assertNotNull(result);
    }
    
}
