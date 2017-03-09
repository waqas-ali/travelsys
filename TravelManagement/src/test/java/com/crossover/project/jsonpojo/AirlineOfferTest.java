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
public class AirlineOfferTest {
    
    public AirlineOfferTest() {
    }

    /**
     * Test of getPrice method, of class AirlineOffer.
     */
    @Test
    public void testGetPrice() {
        
        AirlineOffer instance = new AirlineOffer();
        MonetaryAmount expResult = new MonetaryAmount();
        instance.setPrice(expResult);
        MonetaryAmount result = instance.getPrice();
        assertNotNull(result);
        
    }

    /**
     * Test of setPrice method, of class AirlineOffer.
     */
    @Test
    public void testSetPrice() {
        AirlineOffer instance = new AirlineOffer();
        MonetaryAmount expResult = new MonetaryAmount();
        instance.setPrice(expResult);
        MonetaryAmount result = instance.getPrice();
        assertNotNull(result);
    }

    /**
     * Test of getRoute method, of class AirlineOffer.
     */
    @Test
    public void testGetRoute() {
        
        AirlineOffer instance = new AirlineOffer();
        instance.setRoute(new AirlineRoute());
        AirlineRoute result = instance.getRoute();
        assertNotNull(result);
    }

    /**
     * Test of setRoute method, of class AirlineOffer.
     */
    @Test
    public void testSetRoute() {
        AirlineOffer instance = new AirlineOffer();
        instance.setRoute(new AirlineRoute());
        AirlineRoute result = instance.getRoute();
        assertNotNull(result);
    }
    
}
