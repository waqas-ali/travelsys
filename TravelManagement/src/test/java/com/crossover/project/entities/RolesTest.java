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
public class RolesTest {
    
    public RolesTest() {
    }

    /**
     * Test of values method, of class Roles.
     */
    @Test
    public void testValues() {
        Roles[] expResult = {Roles.ROLE_ADMIN,Roles.ROLE_USER};
        Roles[] result = Roles.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Roles.
     */
    @Test
    public void testValueOf() {
        String name = "ROLE_ADMIN";
        Roles expResult = Roles.ROLE_ADMIN;
        Roles result = Roles.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
