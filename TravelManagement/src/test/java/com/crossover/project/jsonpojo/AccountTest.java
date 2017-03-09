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
public class AccountTest {
    
    public AccountTest() {
    }

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testGetId() {
        String expResult = "123";
        Account instance = new Account();
        instance.setId(expResult);
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        String expResult = "123";
        Account instance = new Account();
        instance.setId(expResult);
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        Account instance = new Account();
        MonetaryAmount expResult = new MonetaryAmount();
        instance.setBalance(expResult);
        MonetaryAmount result = instance.getBalance();
        assertNotNull(result);
    }

    /**
     * Test of setBalance method, of class Account.
     */
    @Test
    public void testSetBalance() {
        Account instance = new Account();
        MonetaryAmount expResult = new MonetaryAmount();
        instance.setBalance(expResult);
        MonetaryAmount result = instance.getBalance();
        assertNotNull(result);
    }
    
}
