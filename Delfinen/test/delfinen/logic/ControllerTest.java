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

    Controller c = new Controller(new DataAccessorFile(), new BetalingCalculator());

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
        ArrayList<Medlem> expResult = new ArrayList();
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Thomas", 1504891953, 17283849, false, "noget@andet.dk");
        expResult.add(new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com"));
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
        int listBefore = c.getMedlemmer().size();
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en større efter vi opretter en motionist
        assertEquals(listBefore, listAfter - 1);
    }

    @Test
    public void testOpretKonkurrencesvømmer() throws Exception {
        System.out.println("opretKonkurrencesvømmer");
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
        Medlem m = new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int listBefore = c.getMedlemmer().size();
        c.sletMedlem(m);
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en mindre efter vi sletter et medlem
        assertEquals(listBefore, listAfter + 1);
    }

    /**
     * Test of søgMedlemPåNavn method, of class Controller.
     */
    @Test
    public void testSøgMedlemPåNavn() throws Exception {
        System.out.println("s\u00f8gMedlemP\u00e5Navn");
        String name = "Frederik";
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200, false, "noget@andet.dk");
        c.opretMotionist("Hans", 10, 10, true, "hans@gmail.com");
        ArrayList result = c.getMedlemPåNavn(name);
        //Vi opretter 3 medlemmer, men forventer kun at få 2 ud når vi søger på navnet Frederik
        assertEquals(2, result.size());
    }

    /**
     * Test of søgMedlemPåCprnr method, of class Controller.
     */
    @Test
    public void testSøgMedlemPåCprnr() throws ClassNotFoundException {
        System.out.println("s\u00f8gMedlemP\u00e5Cprnr");
        int cprnr = 1912891867;
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200, false, "noget@andet.dk");
        c.opretMotionist("Hans", 10, 10, true, "hans@gmail.com");
        Medlem expResult = new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        Medlem result = c.getMedlemPåCprnr(cprnr);
        //Vi søger på cpr nr, og tjekker om vi har fundet den rigtige ved at sammenligne mails
        assertEquals(expResult.getMail(), result.getMail());
    }

    /**
     * Test of søgMedlemPåMail method, of class Controller.
     */
    @Test
    public void testSøgMedlemPåMail() throws ClassNotFoundException {
        System.out.println("s\u00f8gMedlemP\u00e5Mail");
        String mail = "frederiket@gmail.com";
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200, false, "noget@andet.dk");
        c.opretMotionist("Hans", 10, 10, true, "hans@gmail.com");
        Medlem expResult = new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        Medlem result = c.getMedlemPåMail(mail);
        //Vi søger på mail, og tjekker om vi har fundet den rigtige ved at sammenligne cprnr
        assertEquals(expResult.getCprnr(), result.getCprnr());
    }

    /**
     * Test of redigerMedlem method, of class Controller.
     */
    @Test
    public void testRedigerMedlem() throws ClassNotFoundException {
        System.out.println("redigerMedlem");
        Medlem m = new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        String newName = "Hans";
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        c.redigerMedlem(m, newName, newFødselsdato, NewMedlemskabsstatus, newMail);
        Medlem result = c.getMedlemPåCprnr(1912891867);
        //vi tjekker om der nu er et medlem med navnet Hans, m hed originalt Frederik
        assertEquals("Hans", result.getName());
    }

    @Test
    public void testOpretResultat(/*Konkurrencesvømmer konkurrencesvømmer, int timeInSeconds, String date, Disciplin disciplin, String competitionName, int placement*/) {
        /*Resultat r = new Resultat(timeInSeconds, date, disciplin, competitionName, placement);*/
 /*konkurrencesvømmer.setResultater(r);*/
    }

    /**
     * Test of søgKonkurrencesvømmerPåCprnr method, of class Controller.
     */
    @Test
    public void testSøgKonkurrencesvømmerPåCprnr() {
        System.out.println("s\u00f8gKonkurrencesv\u00f8mmerP\u00e5Cprnr");
        Medlem m = new Konkurrencesvømmer("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int cprnr = 1912891867;
        Konkurrencesvømmer expResult = new Konkurrencesvømmer("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        Konkurrencesvømmer result = c.getKonkurrencesvømmerPåCprnr(cprnr);
        assertEquals(expResult.getCprnr(), result.getCprnr());

    }

    /**
     * Test of setTrænernavn method, of class Controller.
     */
    @Test
    public void testSetTrænernavn() {
        System.out.println("setTr\u00e6nernavn");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        String trænernavn = "Talha";
        c.setTrænernavn(c.getKonkurrencesvømmerPåCprnr(1912891867), trænernavn);
        assertEquals("Talha", c);

    }

    /**
     * Test of søgAlleResultater method, of class Controller.
     */
    @Test
    public void testSøgAlleResultater() {
        System.out.println("s\u00f8gAlleResultater");
        Controller instance = null;
        ArrayList<Resultat> expResult = null;
        ArrayList<Resultat> result = instance.getAlleResultater();
        assertEquals(expResult, result);

    }

    /**
     * Test of søgCrawlResultater method, of class Controller.
     */
    @Test
    public void testSøgCrawlResultater() {
        System.out.println("s\u00f8gCrawlResultater");
        Controller instance = null;
        ArrayList<Resultat> expResult = null;
        ArrayList<Resultat> result = instance.getBrystsvømningResultater();
        assertEquals(expResult, result);

    }

    /**
     * Test of søgRygrawlResultater method, of class Controller.
     */
    @Test
    public void testSøgRygrawlResultater() {
        System.out.println("s\u00f8gRygrawlResultater");
        Controller instance = null;
        ArrayList<Resultat> expResult = null;
        ArrayList<Resultat> result = instance.getRygrawlResultater();
        assertEquals(expResult, result);

    }

    /**
     * Test of søgButterflyResultater method, of class Controller.
     */
    @Test
    public void testSøgButterflyResultater() {
        System.out.println("s\u00f8gButterflyResultater");
        Controller instance = null;
        ArrayList<Resultat> expResult = null;
        ArrayList<Resultat> result = instance.getButterflyResultater();
        assertEquals(expResult, result);

    }

    /**
     * Test of søgBrystsvømningResultater method, of class Controller.
     */
    @Test
    public void testSøgBrystsvømningResultater() {
        System.out.println("s\u00f8gBrystsv\u00f8mningResultater");
        Controller instance = null;
        ArrayList<Resultat> expResult = null;
        ArrayList<Resultat> result = instance.getBrystsvømningResultater();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTop5 method, of class Controller.
     */
    @Test
    public void testGetTop5() {
        System.out.println("getTop5");
        Konkurrencesvømmer m = c.getKonkurrencesvømmerPåCprnr(1912891867);
        c.opretResultat(m, 200, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 100, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 100, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 500, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 700, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 300, "10/10/1999", Disciplin.CRAWL, null, 0);
        
        c.getTop5(Disciplin.CRAWL);
        //Disciplin disciplin = null;
        ArrayList<Resultat> expResult = c.getTop5(Disciplin.CRAWL);
        ArrayList<Resultat> result = c.getTop5(Disciplin.CRAWL);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRestanceForMedlem method, of class Controller.
     */
    @Test
    public void testGetRestanceForMedlem() {
        System.out.println("getRestanceForMedlem");
        Medlem medlem = null;
        Controller instance = null;
        int expResult = 0;
        int result = instance.getRestanceForMedlem(medlem);
        assertEquals(expResult, result);

    }

    /**
     * Test of getMedlemmerIRestance method, of class Controller.
     */
    @Test
    public void testGetMedlemmerIRestance() {
        System.out.println("getMedlemmerIRestance");
        Controller instance = null;
        ArrayList<Medlem> expResult = null;
        ArrayList<Medlem> result = instance.getMedlemmerIRestance();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRestanceForYear method, of class Controller.
     */
    @Test
    public void testGetRestanceForYear() {
        System.out.println("getRestanceForYear");
        int year = 100;
        Controller instance = null;
        int expResult = 0;
        int result = c.getRestanceForYear(year);
        assertEquals(expResult, result);

    }

    /**
     * Test of getForventetIndkomstFraKontingenter method, of class Controller.
     */
    @Test
    public void testGetForventetIndkomstFraKontingenter() {
        System.out.println("getForventetIndkomstFraKontingenter");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 2010, true, "frederiket@gmail.com");
       // c.opretBetaling(Medlem, 0, true);
        c.opretKonkurrencesvømmer("Hans", 1912891867, 1990, true, "frederiket@gmail.com");   
        int year = 2018;
        int expResult = 0;
        int result = c.getForventetIndkomstFraKontingenter(year);
        assertEquals(expResult, result);

    }
}
