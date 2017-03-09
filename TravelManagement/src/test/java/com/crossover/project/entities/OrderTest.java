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
public class OrderTest {
    
    public OrderTest() {
    }

    /**
     * Test of getId method, of class Order.
     */
    @Test
    public void testGetId() {
        long expResult = 1L;
        Order instance = new Order();
        instance.setId(expResult);
        long result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Order.
     */
    @Test
    public void testSetId() {
        long expResult = 1L;
        Order instance = new Order();
        instance.setId(expResult);
        long result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAccountId method, of class Order.
     */
    @Test
    public void testGetAccountId() {
        String expResult = "123";
        Order instance = new Order();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccountId method, of class Order.
     */
    @Test
    public void testSetAccountId() {
        String expResult = "123";
        Order instance = new Order();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFrom method, of class Order.
     */
    @Test
    public void testGetFrom() {
        String expResult = "city";
        Order instance = new Order();
        instance.setFrom(expResult);
        String result = instance.getFrom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFrom method, of class Order.
     */
    @Test
    public void testSetFrom() {
        String expResult = "city";
        Order instance = new Order();
        instance.setFrom(expResult);
        String result = instance.getFrom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTo method, of class Order.
     */
    @Test
    public void testGetTo() {
        String expResult = "city";
        Order instance = new Order();
        instance.setTo(expResult);
        String result = instance.getTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTo method, of class Order.
     */
    @Test
    public void testSetTo() {
        String expResult = "city";
        Order instance = new Order();
        instance.setTo(expResult);
        String result = instance.getTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalPrice method, of class Order.
     */
    @Test
    public void testGetTotalPrice() {
        double expResult = 120.0;
        Order instance = new Order();
        instance.setTotalPrice(expResult);
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTotalPrice method, of class Order.
     */
    @Test
    public void testSetTotalPrice() {
        double expResult = 120.0;
        Order instance = new Order();
        instance.setTotalPrice(expResult);
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTickets method, of class Order.
     */
    @Test
    public void testGetTickets() {
        long expResult = 10L;
        Order instance = new Order();
        instance.setTickets(expResult);
        long result = instance.getTickets();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTickets method, of class Order.
     */
    @Test
    public void testSetTickets() {
        long expResult = 10L;
        Order instance = new Order();
        instance.setTickets(expResult);
        long result = instance.getTickets();
        assertEquals(expResult, result);
    }
    
}
