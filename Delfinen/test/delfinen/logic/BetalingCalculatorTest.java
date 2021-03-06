package delfinen.logic;

import delfinen.data.Motionist;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BetalingCalculatorTest {
    
    public BetalingCalculatorTest() {
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
     * Test of udregnBetaling method, of class BetalingCalculator.
     */
    @Test
    public void testUdregnVoksen() {
        Motionist motionist = new Motionist("Bob", 251078, 1978, true, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 1600;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testUdregnJunior() {
        Motionist motionist = new Motionist("Bob", 251078, 1998, true, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 1000;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testUdregnSenior() {
        Motionist motionist = new Motionist("Bob", 251078, 1938, true, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 1200;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testUdregnPassiv() {
        Motionist motionist = new Motionist("Bob", 251078, 1978, false, "mail@.com");
        int year = 2008;
        BetalingCalculator instance = new BetalingCalculator();
        int expResult = 500;
        int result = instance.udregnBetaling(motionist, year);
        assertEquals(expResult, result);

    }
    
}
