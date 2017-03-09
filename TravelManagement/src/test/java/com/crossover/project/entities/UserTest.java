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
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of getCurrency method, of class User.
     */
    @Test
    public void testGetCurrency() {
        String expResult = "EUR";
        User instance = new User();
        instance.setCurrency(expResult);
        String result = instance.getCurrency();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurrency method, of class User.
     */
    @Test
    public void testSetCurrency() {
        String expResult = "EUR";
        User instance = new User();
        instance.setCurrency(expResult);
        String result = instance.getCurrency();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccountId method, of class User.
     */
    @Test
    public void testGetAccountId() {
        String expResult = "";
        User instance = new User();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccountId method, of class User.
     */
    @Test
    public void testSetAccountId() {
       String expResult = "";
        User instance = new User();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        String expResult = "ROLE_ADMIN";
        User instance = new User();
        instance.setRole(expResult);
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        String expResult = "ROLE_ADMIN";
        User instance = new User();
        instance.setRole(expResult);
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        String expResult = "waqas@gmail.com";
        User instance = new User();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        String expResult = "waqas@gmail.com";
        User instance = new User();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        String expResult = "abcd@123";
        User instance = new User();
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        String expResult = "abcd@123";
        User instance = new User();
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }
    
}
