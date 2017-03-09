/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author waqas.ali2
 */
public class JqDataTableTest {

    public JqDataTableTest() {
    }

    /**
     * Test of getRecordsTotal method, of class JqDataTable.
     */
    @Test
    public void testGetRecordsTotal() {
        int recordsTotal = 10;
        JqDataTable instance = new JqDataTable();
        instance.setRecordsTotal(recordsTotal);
        assertEquals(recordsTotal, instance.getRecordsTotal());
    }

    /**
     * Test of setRecordsTotal method, of class JqDataTable.
     */
    @Test
    public void testSetRecordsTotal() {
        int recordsTotal = 10;
        JqDataTable instance = new JqDataTable();
        instance.setRecordsTotal(recordsTotal);
        assertEquals(recordsTotal, instance.getRecordsTotal());
    }

    /**
     * Test of getRecordsFiltered method, of class JqDataTable.
     */
    @Test
    public void testGetRecordsFiltered() {
        JqDataTable instance = new JqDataTable();
        int expResult = 5;
        instance.setRecordsFiltered(expResult);
        int result = instance.getRecordsFiltered();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRecordsFiltered method, of class JqDataTable.
     */
    @Test
    public void testSetRecordsFiltered() {
        JqDataTable instance = new JqDataTable();
        int expResult = 5;
        instance.setRecordsFiltered(expResult);
        int result = instance.getRecordsFiltered();
        assertEquals(expResult, result);
    }

    /**
     * Test of getsEcho method, of class JqDataTable.
     */
    @Test
    public void testGetsEcho() {
        int expResult = 1;
        JqDataTable instance = new JqDataTable();
        instance.setsEcho(expResult);
        int result = instance.getsEcho();
        assertEquals(expResult, result);
    }

    /**
     * Test of setsEcho method, of class JqDataTable.
     */
    @Test
    public void testSetsEcho() {
        int expResult = 1;
        JqDataTable instance = new JqDataTable();
        instance.setsEcho(expResult);
        int result = instance.getsEcho();
        assertEquals(expResult, result);
    }

    /**
     * Test of getiDisplayLength method, of class JqDataTable.
     */
    @Test
    public void testGetiDisplayLength() {
        int expResult = 20;
        JqDataTable instance = new JqDataTable();
        instance.setiDisplayLength(expResult);
        int result = instance.getiDisplayLength();
        assertEquals(expResult, result);

    }

    /**
     * Test of setiDisplayLength method, of class JqDataTable.
     */
    @Test
    public void testSetiDisplayLength() {
        int expResult = 20;
        JqDataTable instance = new JqDataTable();
        instance.setiDisplayLength(expResult);
        int result = instance.getiDisplayLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDraw method, of class JqDataTable.
     */
    @Test
    public void testGetDraw() {
        int expResult = 2;
        JqDataTable instance = new JqDataTable();
        instance.setDraw(expResult);
        int result = instance.getDraw();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDraw method, of class JqDataTable.
     */
    @Test
    public void testSetDraw() {
        int expResult = 2;
        JqDataTable instance = new JqDataTable();
        instance.setDraw(expResult);
        int result = instance.getDraw();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAaData method, of class JqDataTable.
     */
    @Test
    public void testGetAaData() {

        JqDataTable instance = new JqDataTable();
        List<String> expResult = new ArrayList<>();
        expResult.add("London");
        expResult.add("New York");
        instance.setAaData(expResult);
        List result = instance.getAaData();
        assertNotNull(result);
    }

    /**
     * Test of setAaData method, of class JqDataTable.
     */
    @Test
    public void testSetAaData() {
        JqDataTable instance = new JqDataTable();
        List<String> expResult = new ArrayList<>();
        expResult.add("London");
        expResult.add("New York");
        instance.setAaData(expResult);
        List result = instance.getAaData();
        assertNotNull(result);
    }

}
