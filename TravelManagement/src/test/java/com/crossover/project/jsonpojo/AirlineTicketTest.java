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
public class AirlineTicketTest {
    
    public AirlineTicketTest() {
    }

    /**
     * Test of getAmount method, of class AirlineTicket.
     */
    @Test
    public void testGetAmount() {
        long expResult = 100L;
        AirlineTicket instance = new AirlineTicket();
        instance.setAmount(expResult);
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount method, of class AirlineTicket.
     */
    @Test
    public void testSetAmount() {
        long expResult = 100L;
        AirlineTicket instance = new AirlineTicket();
        instance.setAmount(expResult);
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDetails method, of class AirlineTicket.
     */
    @Test
    public void testGetDetails() {
        AirlineTicket instance = new AirlineTicket();
        instance.setDetails(new AirlineOffer());
        AirlineOffer result = instance.getDetails();
        assertNotNull(result);
    }

    /**
     * Test of setDetails method, of class AirlineTicket.
     */
    @Test
    public void testSetDetails() {
        AirlineTicket instance = new AirlineTicket();
        instance.setDetails(new AirlineOffer());
        AirlineOffer result = instance.getDetails();
        assertNotNull(result);
    }
    
}
