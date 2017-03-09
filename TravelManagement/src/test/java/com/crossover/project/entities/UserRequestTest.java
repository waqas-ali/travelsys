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
public class UserRequestTest {
    
    public UserRequestTest() {
    }

    /**
     * Test of getRole method, of class UserRequest.
     */
    @Test
    public void testGetRole() {
        String expResult = "ROLE_ADMIN";
        UserRequest instance = new UserRequest();
        instance.setRole(expResult);
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class UserRequest.
     */
    @Test
    public void testSetRole() {
        String expResult = "ROLE_ADMIN";
        UserRequest instance = new UserRequest();
        instance.setRole(expResult);
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class UserRequest.
     */
    @Test
    public void testGetEmail() {
        String expResult = "waqas@gmail.com";
        UserRequest instance = new UserRequest();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class UserRequest.
     */
    @Test
    public void testSetEmail() {
        String expResult = "waqas@gmail.com";
        UserRequest instance = new UserRequest();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class UserRequest.
     */
    @Test
    public void testGetPassword() {
        String expResult = "abcd@123";
        UserRequest instance = new UserRequest();
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class UserRequest.
     */
    @Test
    public void testSetPassword() {
        String expResult = "abcd@123";
        UserRequest instance = new UserRequest();
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }
    
}
