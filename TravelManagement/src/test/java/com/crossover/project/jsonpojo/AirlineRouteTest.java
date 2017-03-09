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
public class AirlineRouteTest {
    
    public AirlineRouteTest() {
    }

    /**
     * Test of getFrom method, of class AirlineRoute.
     */
    @Test
    public void testGetFrom() {
        String expResult = "london";
        AirlineRoute instance = new AirlineRoute();
        instance.setFrom(expResult);
        String result = instance.getFrom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFrom method, of class AirlineRoute.
     */
    @Test
    public void testSetFrom() {
        String expResult = "london";
        AirlineRoute instance = new AirlineRoute();
        instance.setFrom(expResult);
        String result = instance.getFrom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTo method, of class AirlineRoute.
     */
    @Test
    public void testGetTo() {
        String expResult = "london";
        AirlineRoute instance = new AirlineRoute();
        instance.setTo(expResult);
        String result = instance.getTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTo method, of class AirlineRoute.
     */
    @Test
    public void testSetTo() {
        String expResult = "london";
        AirlineRoute instance = new AirlineRoute();
        instance.setTo(expResult);
        String result = instance.getTo();
        assertEquals(expResult, result);
    }
    
}
