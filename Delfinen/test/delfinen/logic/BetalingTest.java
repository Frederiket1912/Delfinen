/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.Medlem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author SebastianBernthJepse
 */
public class BetalingTest {
    
    public BetalingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of udregnBetaling method, of class Betaling.
     */
    @Test
    public void testUdregnBetaling() {
        System.out.println("udregnBetaling");
        Medlem medlem = null;
        int year = 0;
        Betaling instance = new Betaling();
        int expResult = 0;
        int result = instance.udregnBetaling(medlem, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}