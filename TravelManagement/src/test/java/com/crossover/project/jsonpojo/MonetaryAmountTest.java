/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.jsonpojo;

import com.crossover.project.entities.Currency;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waqas.ali2
 */
public class MonetaryAmountTest {
    
    public MonetaryAmountTest() {
    }

    /**
     * Test of getAmount method, of class MonetaryAmount.
     */
    @Test
    public void testGetAmount() {
        double expResult = 1200.0;
        MonetaryAmount instance = new MonetaryAmount();
        instance.setAmount(expResult);
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setAmount method, of class MonetaryAmount.
     */
    @Test
    public void testSetAmount() {
        double expResult = 1200.0;
        MonetaryAmount instance = new MonetaryAmount();
        instance.setAmount(expResult);
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCurrency method, of class MonetaryAmount.
     */
    @Test
    public void testGetCurrency() {
        Currency expResult = Currency.USD;
        MonetaryAmount instance = new MonetaryAmount();
        instance.setCurrency(expResult);
        Currency result = instance.getCurrency();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurrency method, of class MonetaryAmount.
     */
    @Test
    public void testSetCurrency() {
        Currency expResult = Currency.USD;
        MonetaryAmount instance = new MonetaryAmount();
        instance.setCurrency(expResult);
        Currency result = instance.getCurrency();
        assertEquals(expResult, result);
    }
    
}
