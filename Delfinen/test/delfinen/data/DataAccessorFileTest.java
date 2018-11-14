/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import java.io.File;
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
    private String FILENAME = "Medlemmer.txt";
    
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
        File file = new File(FILENAME);
        long fileBefore = file.length();        
        String name = "";
        int cprnr = 0;
        int fødselsdato = 0;
        boolean medlemskabsstatus = false;
        String mail = "";
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem(name, cprnr, fødselsdato, medlemskabsstatus, mail);
        long fileAfter = file.length();
        //vi tjekker om filen er blevet større efter at der er oprettet et medlem
        assertNotEquals(fileBefore, fileAfter);
    }

    /**
     * Test of getMedlemmer method, of class DataAccessorFile.
     */
    @Test
    public void testGet2Medlemmer() {
        System.out.println("getMedlemmer");
        DataAccessorFile instance = new DataAccessorFile();
        ArrayList<Medlem> expResult = new ArrayList();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        instance.opretMedlem("Thomas", 1504891953, 17283849, false, "noget@andet.dk");
        expResult.add(new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com"));
        expResult.add(new Medlem("Thomas", 1504891953, 17283849, false, "noget@andet.dk"));
        ArrayList<Medlem> result = instance.getMedlemmer();
        //vi tjekker om der er to medlemmer i begge arrays
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of sletMedlem method, of class DataAccessorFile.
     */
    @Test
    public void testSletMedlem() {
        System.out.println("sletMedlem");
        Medlem medlem = new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        DataAccessorFile instance = new DataAccessorFile();
        File file = new File(FILENAME);
        long fileBefore = file.length();
        instance.sletMedlem(medlem);
        long fileAfter = file.length();
        assertNotEquals(fileBefore, fileAfter);
    }

    /**
     * Test of søgMedlemPåNavn method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåNavn() {
        System.out.println("s\u00f8gMedlemP\u00e5Navn");
        String name = "Frederik";
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        ArrayList expResult = new ArrayList();
        expResult.add(new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com"));
        ArrayList result = instance.søgMedlemPåNavn(name);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of søgMedlemPåCprnr method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåCprnr() {
        System.out.println("s\u00f8gMedlemP\u00e5Cprnr");
        int cprnr = 1912891867;
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        ArrayList expResult = new ArrayList();
        expResult.add(new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com"));
        ArrayList result = instance.søgMedlemPåCprnr(cprnr);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of søgMedlemPåMail method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåMail() {
        System.out.println("s\u00f8gMedlemP\u00e5Mail");
        String mail = "frederiket@gmail.com";
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        ArrayList expResult = new ArrayList();
        expResult.add(new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com"));
        ArrayList result = instance.søgMedlemPåMail(mail);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of redigerMedlem method, of class DataAccessorFile.
     */
    @Test
    public void testRedigerMedlem2() {
        System.out.println("redigerMedlem");
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem m = instance.søgMedlemPåCprnr2(1912891867);
        String newName = "Hans";
        int newCprnr = 100200;
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        instance.redigerMedlem2(m, newName, newCprnr, newFødselsdato, NewMedlemskabsstatus, newMail);
        assertEquals("Hans", instance.søgMedlemPåCprnr2(100200).getName());
    }

    /**
     * Test of søgMedlemPåCprnr2 method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåCprnr2() {
        System.out.println("s\u00f8gMedlemP\u00e5Cprnr2");
        int cprnr = 1912891867;
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem expResult = new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem result = instance.søgMedlemPåCprnr2(cprnr);
        assertEquals(expResult.getMail(), result.getMail());
    }

    /**
     * Test of søgMedlemPåMail2 method, of class DataAccessorFile.
     */
    @Test
    public void testSøgMedlemPåMail2() {
        System.out.println("s\u00f8gMedlemP\u00e5Mail2");
        String mail = "frederiket@gmail.com";
        DataAccessorFile instance = new DataAccessorFile();
        instance.opretMedlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem expResult = new Medlem("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem result = instance.søgMedlemPåMail2(mail);
        assertEquals(expResult.getCprnr(), result.getCprnr());
    }
    
}
