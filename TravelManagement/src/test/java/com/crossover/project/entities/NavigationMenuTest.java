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
public class NavigationMenuTest {
    
    public NavigationMenuTest() {
    }

    /**
     * Test of getPageName method, of class NavigationMenu.
     */
    @Test
    public void testGetPageName() {
        String expResult = "home";
        NavigationMenu instance = new NavigationMenu();
        instance.setPageName(expResult);
        String result = instance.getPageName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPageName method, of class NavigationMenu.
     */
    @Test
    public void testSetPageName() {
        String expResult = "home";
        NavigationMenu instance = new NavigationMenu();
        instance.setPageName(expResult);
        String result = instance.getPageName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPageURL method, of class NavigationMenu.
     */
    @Test
    public void testGetPageURL() {
        String expResult = "url";
        NavigationMenu instance = new NavigationMenu();
        instance.setPageURL(expResult);
        String result = instance.getPageURL();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPageURL method, of class NavigationMenu.
     */
    @Test
    public void testSetPageURL() {
        String expResult = "url";
        NavigationMenu instance = new NavigationMenu();
        instance.setPageURL(expResult);
        String result = instance.getPageURL();
        assertEquals(expResult, result);
    }
    
}
