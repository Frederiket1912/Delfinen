/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frede
 */
public class DataAccessorFileTest {
    
    public DataAccessorFileTest() {
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
     * Test of opretMedlem method, of class DataAccessorFile.
     */
    @Test
    public void testOpretMedlem() {
        System.out.println("opretMedlem");
        String name = "";
        int cprnr = 0;
        boolean medlemskabsstatus = false;
        String mail = "";
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem(name, cprnr, medlemskabsstatus, mail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedlemmer method, of class DataAccessorFile.
     */
    @Test
    public void testGet2Medlemmer() {
        System.out.println("getMedlemmer");
        DataAccessorFile instance = new DataAccessorFile();
        ArrayList<Medlem> expResult = new ArrayList();
        Medlem m = new Medlem("Frederik", 1912891867, true, "frederiket@gmail.com");
        expResult.add(m);
        expResult.add(m);
        ArrayList<Medlem> result = instance.getMedlemmer();
        assertEquals(expResult.size(), result.size());        
    }

    /**
     * Test of sletMedlem method, of class DataAccessorFile.
     */
    @Test
    public void testSletMedlem() {
        System.out.println("sletMedlem");
        Medlem medlem = null;
        DataAccessorFile instance = new DataAccessorFile();
        instance.sletMedlem(medlem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of søgMedlemPåNavn method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåNavn() {
        System.out.println("s\u00f8gMedlemP\u00e5Navn");
        String name = "";
        DataAccessorFile instance = new DataAccessorFile();
        ArrayList expResult = null;
        ArrayList result = instance.søgMedlemPåNavn(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of søgMedlemPåCprnr method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåCprnr() {
        System.out.println("s\u00f8gMedlemP\u00e5Cprnr");
        int cprnr = 0;
        DataAccessorFile instance = new DataAccessorFile();
        ArrayList expResult = null;
        ArrayList result = instance.søgMedlemPåCprnr(cprnr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of søgMedlemPåMail method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåMail() {
        System.out.println("s\u00f8gMedlemP\u00e5Mail");
        String mail = "";
        DataAccessorFile instance = new DataAccessorFile();
        ArrayList expResult = null;
        ArrayList result = instance.søgMedlemPåMail(mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redigerMedlem method, of class DataAccessorFile.
     */
    @Test
    public void testRedigerMedlem() {
        System.out.println("redigerMedlem");
        Medlem medlem = null;
        String newName = "";
        int newCprnr = 0;
        boolean NewMedlemskabsstatus = false;
        String newMail = "";
        DataAccessorFile instance = new DataAccessorFile();
        instance.redigerMedlem(medlem, newName, newCprnr, NewMedlemskabsstatus, newMail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of søgMedlemPåCprnr2 method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåCprnr2() {
        System.out.println("s\u00f8gMedlemP\u00e5Cprnr2");
        int cprnr = 0;
        DataAccessorFile instance = new DataAccessorFile();
        Medlem expResult = null;
        Medlem result = instance.søgMedlemPåCprnr2(cprnr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of søgMedlemPåMail2 method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåMail2() {
        System.out.println("s\u00f8gMedlemP\u00e5Mail2");
        String mail = "";
        DataAccessorFile instance = new DataAccessorFile();
        Medlem expResult = null;
        Medlem result = instance.søgMedlemPåMail2(mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
