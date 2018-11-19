/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.Betaling;
import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Konkurrencesvømmer;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
import delfinen.data.Resultat;
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
public class ControllerTest {
    
    public ControllerTest() {
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
     * Test of getMedlemmer method, of class Controller.
     */
    @Test
    public void testGetMedlemmer() throws ClassNotFoundException {
        System.out.println("getMedlemmer");
        Controller c = new Controller(new DataAccessorFile());
        ArrayList<Medlem> expResult = new ArrayList();
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        c.opretMotionist("Thomas", 1504891953, 17283849, false, "noget@andet.dk");
        expResult.add(new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com"));
        expResult.add(new Motionist("Thomas", 1504891953, 17283849, false, "noget@andet.dk"));
        ArrayList<Medlem> result = c.getMedlemmer();
        //vi tjekker om der er det samme antal medlemmer i begge arrays
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of opretMedlem method, of class Controller.
     */
    @Test
    public void testOpretMotionist() throws Exception {
        System.out.println("opretMedlem");
        Controller c = new Controller(new DataAccessorFile());
        int listBefore = c.getMedlemmer().size();
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en større efter vi opretter en motionist
        assertEquals(listBefore, listAfter - 1);
    }
    
    @Test
    public void testOpretKonkurrencesvømmer() throws Exception {
        System.out.println("opretKonkurrencesvømmer");
        Controller c = new Controller(new DataAccessorFile());
        int listBefore = c.getMedlemmer().size();
        ArrayList<Betaling> betaling = new ArrayList();
        ArrayList<Resultat> resultater = new ArrayList();
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en større efter vi opretter en konkurrencesvømmer
        assertEquals(listBefore, listAfter - 1);
    }

    /**
     * Test of sletMedlem method, of class Controller.
     */
    @Test
    public void testSletMedlem() throws Exception {
        System.out.println("sletMedlem");
        Controller c = new Controller(new DataAccessorFile());
        Medlem m = new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        int listBefore = c.getMedlemmer().size();
        c.sletMedlem(m);
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en mindre efter vi sletter et medlem
        assertEquals(listBefore, listAfter +1);
    }

    /**
     * Test of søgMedlemPåNavn method, of class Controller.
     */
    @Test
    public void testSøgMedlemPåNavn() throws Exception {
        System.out.println("s\u00f8gMedlemP\u00e5Navn");
        Controller c = new Controller(new DataAccessorFile());
        String name = "Frederik";
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200,false,"noget@andet.dk");
        c.opretMotionist("Hans", 10,10,true,"hans@gmail.com");
        ArrayList result = c.søgMedlemPåNavn(name);
        //Vi opretter 3 medlemmer, men forventer kun at få 2 ud når vi søger på navnet Frederik
        assertEquals(2, result.size());
    }

    /**
     * Test of søgMedlemPåCprnr method, of class Controller.
     */
    @Test
    public void testSøgMedlemPåCprnr() throws ClassNotFoundException {
        System.out.println("s\u00f8gMedlemP\u00e5Cprnr");
        Controller c = new Controller(new DataAccessorFile());
        int cprnr = 1912891867;
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200,false,"noget@andet.dk");
        c.opretMotionist("Hans", 10,10,true,"hans@gmail.com");
        Medlem expResult = new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem result = c.søgMedlemPåCprnr(cprnr);
        //Vi søger på cpr nr, og tjekker om vi har fundet den rigtige ved at sammenligne mails
        assertEquals(expResult.getMail(), result.getMail());
    }

    /**
     * Test of søgMedlemPåMail method, of class Controller.
     */
    @Test
    public void testSøgMedlemPåMail() throws ClassNotFoundException {
        System.out.println("s\u00f8gMedlemP\u00e5Mail");
        Controller c = new Controller(new DataAccessorFile());
        String mail = "frederiket@gmail.com";
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200,false,"noget@andet.dk");
        c.opretMotionist("Hans", 10,10,true,"hans@gmail.com");
        Medlem expResult = new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        Medlem result = c.søgMedlemPåMail(mail);
        //Vi søger på mail, og tjekker om vi har fundet den rigtige ved at sammenligne cprnr
        assertEquals(expResult.getCprnr(), result.getCprnr());
    }

    /**
     * Test of redigerMedlem method, of class Controller.
     */
    @Test
    public void testRedigerMedlem() throws ClassNotFoundException {
        System.out.println("redigerMedlem");
        Controller c = new Controller(new DataAccessorFile());
        Medlem m = new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        c.opretMotionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        String newName = "Hans";
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        c.redigerMedlem(m, newName, newFødselsdato, NewMedlemskabsstatus, newMail);
        Medlem result = c.søgMedlemPåCprnr(1912891867);
        //vi tjekker om der nu er et medlem med navnet Hans, m hed originalt Frederik
        assertEquals("Hans", result.getName());
    }
    
    @Test
    public void testOpretResultat(/*Konkurrencesvømmer konkurrencesvømmer, int timeInSeconds, String date, Disciplin disciplin, String competitionName, int placement*/) {
        /*Resultat r = new Resultat(timeInSeconds, date, disciplin, competitionName, placement);*/
        /*konkurrencesvømmer.setResultater(r);*/
    }
}

