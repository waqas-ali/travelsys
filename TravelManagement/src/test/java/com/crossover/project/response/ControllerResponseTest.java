/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waqas.ali2
 */
public class ControllerResponseTest {
    
    public ControllerResponseTest() {
    }

    /**
     * Test of getMessage method, of class ControllerResponse.
     */
    @org.junit.Test
    public void testGetMessage() {
        String expResult = "Get";
        ControllerResponse instance = new ControllerResponse();
        instance.setMessage(expResult);
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class ControllerResponse.
     */
    @org.junit.Test
    public void testSetMessage() {        
        String expResult = "Set";
        ControllerResponse instance = new ControllerResponse();
        instance.setMessage(expResult);
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ControllerResponse.
     */
    @org.junit.Test
    public void testGetStatus() {
        String expResult = "Get";
        ControllerResponse instance = new ControllerResponse();
        instance.setStatus(expResult);
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class ControllerResponse.
     */
    @org.junit.Test
    public void testSetStatus() {
        String expResult = "Set";
        ControllerResponse instance = new ControllerResponse();
        instance.setStatus(expResult);
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
}
