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
public class CurrencyTest {
    
    public CurrencyTest() {
    }

    /**
     * Test of values method, of class Currency.
     */
    @Test
    public void testValues() {
        Currency[] expResult = {Currency.USD,Currency.EUR};
        Currency[] result = Currency.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Currency.
     */
    @Test
    public void testValueOf() {
        String name = "USD";
        Currency expResult = Currency.USD;
        Currency result = Currency.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
