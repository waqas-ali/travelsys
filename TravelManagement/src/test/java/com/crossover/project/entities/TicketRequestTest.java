/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waqas.ali2
 */
public class TicketRequestTest {
    
    public TicketRequestTest() {
    }

    /**
     * Test of getAmount method, of class TicketRequest.
     */
    @Test
    public void testGetAmount() {
        long expResult = 10L;
        TicketRequest instance = new TicketRequest();
        instance.setAmount(expResult);
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount method, of class TicketRequest.
     */
    @Test
    public void testSetAmount() {
        long expResult = 10L;
        TicketRequest instance = new TicketRequest();
        instance.setAmount(expResult);
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFrom method, of class TicketRequest.
     */
    @Test
    public void testGetFrom() {
        String expResult = "city";
        TicketRequest instance = new TicketRequest();
        instance.setFrom(expResult);
        String result = instance.getFrom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFrom method, of class TicketRequest.
     */
    @Test
    public void testSetFrom() {
        String expResult = "city";
        TicketRequest instance = new TicketRequest();
        instance.setFrom(expResult);
        String result = instance.getFrom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTo method, of class TicketRequest.
     */
    @Test
    public void testGetTo() {
        String expResult = "city";
        TicketRequest instance = new TicketRequest();
        instance.setTo(expResult);
        String result = instance.getTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTo method, of class TicketRequest.
     */
    @Test
    public void testSetTo() {
        String expResult = "city";
        TicketRequest instance = new TicketRequest();
        instance.setTo(expResult);
        String result = instance.getTo();
        assertEquals(expResult, result);
    }
    
}
