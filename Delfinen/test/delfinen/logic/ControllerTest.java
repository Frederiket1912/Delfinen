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
    public void testGetMedlemPåNavn() throws Exception {
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
    public void testGetMedlemPåCprnr() throws ClassNotFoundException {
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
    public void testGetMedlemPåMail() throws ClassNotFoundException {
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
    public void testgetKonkurrencesvømmerPåCprnr() {
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
        assertEquals("Talha", c.getKonkurrencesvømmerPåCprnr(1912891867).getTrænernavn());

    }

    /**
     * Test of søgAlleResultater method, of class Controller.
     */
    @Test
    public void testGetAlleResultater() {
        System.out.println("s\u00f8gAlleResultater");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        int expResult = 6;
        int result = c.getAlleResultater().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of søgCrawlResultater method, of class Controller.
     */
    @Test
    public void testgetCrawlResultater() {
        System.out.println("s\u00f8gCrawlResultater");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 2;
        int result = c.getCrawlResultater().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of søgRygrawlResultater method, of class Controller.
     */
    @Test
    public void testgetRygrawlResultater() {
        System.out.println("s\u00f8gRygrawlResultater");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 1;
        int result = c.getRygrawlResultater().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of søgButterflyResultater method, of class Controller.
     */
    @Test
    public void testSøgButterflyResultater() {
        System.out.println("s\u00f8gButterflyResultater");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 2;
        int result = c.getButterflyResultater().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of søgBrystsvømningResultater method, of class Controller.
     */
    @Test
    public void testSøgBrystsvømningResultater() {
        System.out.println("s\u00f8gBrystsv\u00f8mningResultater");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 1;
        int result = c.getBrystsvømningResultater().size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTop5 method, of class Controller.
     */
    @Test
    public void testGetTop5() {
        System.out.println("getTop5");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 2;
        int result = c.getTop5(Disciplin.CRAWL).size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRestanceForMedlem method, of class Controller.
     */
    @Test
    public void testGetRestanceForMedlem() {
        System.out.println("getRestanceForMedlem");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2005, false);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2006, true);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2007, false);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2008, true);
        BetalingCalculator bc = new BetalingCalculator();
        int expResult = 2600;
        int result = c.getRestanceForMedlem(c.getKonkurrencesvømmerPåCprnr(1912891867));
        assertEquals(expResult, result);
    }

    /**
     * Test of getMedlemmerIRestance method, of class Controller.
     */
    @Test
    public void testGetMedlemmerIRestance() {
        System.out.println("getMedlemmerIRestance");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, false);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, false);
        int expResult = 2;
        int result = c.getMedlemmerIRestance().size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRestanceForYear method, of class Controller.
     */
    @Test
    public void testGetRestanceForYear() {
        System.out.println("getRestanceForYear");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, false);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, false);
        int year = 2004;
        int expResult = 2000;
        int result = c.getRestanceForYear(year);
        assertEquals(expResult, result);

    }

    /**
     * Test of getForventetIndkomstFraKontingenter method, of class Controller.
     */
    @Test
    public void testGetForventetIndkomstFraKontingenter() {
        System.out.println("getForventetIndkomstFraKontingenter");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, false);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, false);
        int year = 2004;
        int expResult = 3000;
        int result = c.getForventetIndkomstFraKontingenter(year);
        assertEquals(expResult, result);

    }

    /**
     * Test of getMedlemmerListe method, of class Controller.
     */
    @Test
    public void testGetMedlemmerListe() {
        System.out.println("getMedlemmerListe");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        int expResult = 3;
        int result = c.getMedlemmerListe().size();
        assertEquals(expResult, result);
    }



    /**
     * Test of sletResultat method, of class Controller.
     */
    @Test
    public void testSletResultat() {
        System.out.println("sletResultat");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "hej", Disciplin.CRAWL, "hej", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/2/2004", Disciplin.CRAWL, "hej", 0);
        int resultaterFør = c.getKonkurrencesvømmerPåCprnr(1912891867).getResultater().size();
        Resultat r = c.getKonkurrencesvømmerPåCprnr(1912891867).getResultater().get(0);
        c.sletResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), r);
        int resultaterEfter = c.getKonkurrencesvømmerPåCprnr(1912891867).getResultater().size();
        System.out.println(resultaterEfter);
        assertEquals(resultaterFør, resultaterEfter+1);
    }

    /**
     * Test of getDisciplinResultater method, of class Controller.
     */
    @Test
    public void testGetDisciplinResultater() {
        System.out.println("getDisciplinResultater");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        Disciplin disciplin = null;
        disciplin = disciplin.BRYSTSVØMNING;
        int expResult = 1;
        int result = c.getDisciplinResultater(disciplin).size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getKonkurrencesvømmere method, of class Controller.
     */
    @Test
    public void testGetKonkurrencesvømmere() {
        System.out.println("getKonkurrencesv\u00f8mmere");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        int expResult = 2;
        int result = c.getKonkurrencesvømmere().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBestResult method, of class Controller.
     */
    @Test
    public void testGetBestResult() {
        System.out.println("getBestResult");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);        
        Disciplin disciplin = null;
        disciplin = disciplin.BUTTERFLY;
        int expResult = 300;
        int result = c.getBestResult(c.getKonkurrencesvømmerPåCprnr(1912891867), disciplin).getTimeInSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of timeFormatter method, of class Controller.
     */
    @Test
    public void testTimeFormatter() {
        System.out.println("timeFormatter");
        int time = 126;
        String expResult = "02:06";
        String result = c.timeFormatter(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBetalingByYear method, of class Controller.
     */
    @Test
    public void testGetBetalingByYear() {
        System.out.println("getBetalingByYear");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        int year = 2004;
        int expResult = 0;
        int result = c.getBetalingByYear(c.getMedlemPåCprnr(1912891867), year).getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlleBetalinger method, of class Controller.
     */
    @Test
    public void testGetAlleBetalinger() {
        System.out.println("getAlleBetalinger");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 100200, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2005, false);
        c.opretBetaling(c.getMedlemPåCprnr(100200), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(100200), 2005, true);
        int expResult = 6;
        int result = c.getAlleBetalinger().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of opretBetaling method, of class Controller.
     */
    @Test
    public void testOpretBetaling() {
        System.out.println("opretBetaling");
        Medlem medlem = null;
        int betalingsyear = 0;
        boolean hasPaid = false;
        Controller instance = null;
        instance.opretBetaling(medlem, betalingsyear, hasPaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redigerBetaling method, of class Controller.
     */
    @Test
    public void testRedigerBetaling() {
        System.out.println("redigerBetaling");
        Betaling betaling = null;
        boolean isPaid = false;
        Controller instance = null;
        instance.redigerBetaling(betaling, isPaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
