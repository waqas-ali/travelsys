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
public class SessionEntityTest {

    public SessionEntityTest() {
    }

    /**
     * Test of getRole method, of class SessionEntity.
     */
    @Test
    public void testGetRole() {
        Roles expResult = Roles.ROLE_USER;
        SessionEntity instance = new SessionEntity();
        instance.setRole(expResult);
        Roles result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class SessionEntity.
     */
    @Test
    public void testSetRole() {
        Roles expResult = Roles.ROLE_USER;
        SessionEntity instance = new SessionEntity();
        instance.setRole(expResult);
        Roles result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccountId method, of class SessionEntity.
     */
    @Test
    public void testGetAccountId() {
        String expResult = "12345";
        SessionEntity instance = new SessionEntity();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccountId method, of class SessionEntity.
     */
    @Test
    public void testSetAccountId() {
        String expResult = "12345";
        SessionEntity instance = new SessionEntity();
        instance.setAccountId(expResult);
        String result = instance.getAccountId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrency method, of class SessionEntity.
     */
    @Test
    public void testGetCurrency() {
        String expResult = "USD";
        SessionEntity instance = new SessionEntity();
        instance.setCurrency(expResult);
        String result = instance.getCurrency();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurrency method, of class SessionEntity.
     */
    @Test
    public void testSetCurrency() {
        String expResult = "USD";
        SessionEntity instance = new SessionEntity();
        instance.setCurrency(expResult);
        String result = instance.getCurrency();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEmail method, of class SessionEntity.
     */
    @Test
    public void testGetEmail() {
        String expResult = "waqas@gmail.com";
        SessionEntity instance = new SessionEntity();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class SessionEntity.
     */
    @Test
    public void testSetEmail() {
        String expResult = "waqas@gmail.com";
        SessionEntity instance = new SessionEntity();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

}
