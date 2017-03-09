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
public class DepositWithdrawRequestTest {
    
    public DepositWithdrawRequestTest() {
    }

    /**
     * Test of getAccountId method, of class DepositWithdrawRequest.
     */
    @Test
    public void testGetAccountId() {
        String expResult = "123";
        DepositWithdrawRequest instance = new DepositWithdrawRequest();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccountId method, of class DepositWithdrawRequest.
     */
    @Test
    public void testSetAccountId() {
        String expResult = "123";
        DepositWithdrawRequest instance = new DepositWithdrawRequest();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonetaryAmount method, of class DepositWithdrawRequest.
     */
    @Test
    public void testGetMonetaryAmount() {
        DepositWithdrawRequest instance = new DepositWithdrawRequest();
        instance.setMonetaryAmount(new MonetaryAmount());
        MonetaryAmount result = instance.getMonetaryAmount();
        assertNotNull(result);
    }

    /**
     * Test of setMonetaryAmount method, of class DepositWithdrawRequest.
     */
    @Test
    public void testSetMonetaryAmount() {
        DepositWithdrawRequest instance = new DepositWithdrawRequest();
        instance.setMonetaryAmount(new MonetaryAmount());
        MonetaryAmount result = instance.getMonetaryAmount();
        assertNotNull(result);
    }
    
}
