/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.Motionist;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testUdregnVoksen() {
        System.out.println("udregnVoksen");
        Motionist motionist = new Motionist("Bob", 251078, 1978, true, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 1600;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testUdregnJunior() {
        System.out.println("udregnJunior");
        Motionist motionist = new Motionist("Bob", 251078, 1998, true, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 1000;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testUdregnSenior() {
        System.out.println("udregnSenior");
        Motionist motionist = new Motionist("Bob", 251078, 1938, true, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 1200;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testUdregnPassiv() {
        System.out.println("udregnBetaling");
        Motionist motionist = new Motionist("Bob", 251078, 1978, false, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 500;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
}
