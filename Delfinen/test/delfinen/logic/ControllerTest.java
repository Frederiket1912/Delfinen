package delfinen.logic;

import delfinen.data.Betaling;
import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Motionist;
import delfinen.data.Resultat;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testGet2Medlemmer(){
        int expResult = 2;
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Thomas", 1504891953, 17283849, false, "noget@andet.dk");
        int result = c.getMedlemmer().size();
        //vi tjekker om der er 2 medlemmer i arrayet
        assertEquals(expResult, result);
    }

    /**
     * Test of opretMedlem method, of class Controller.
     */
    @Test
    public void testOpret1Motionist() {
        int listBefore = c.getMedlemmer().size();
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en større efter vi opretter en motionist
        assertEquals(listBefore, listAfter - 1);
    }
    
    /**
     * Test of opretKonkurrencesvømmer method, of class Controller.
     */
    @Test
    public void testOpret1Konkurrencesvømmer() {
        int listBefore = c.getMedlemmer().size();
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en større efter vi opretter en konkurrencesvømmer
        assertEquals(listBefore, listAfter - 1);
    }

    /**
     * Test of sletMedlem method, of class Controller.
     */
    @Test
    public void testSletMedlem() {
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        int listBefore = c.getMedlemmer().size();
        c.sletMedlem(c.getMedlemPåCprnr(1912891867));
        int listAfter = c.getMedlemmer().size();
        //vi tjekker om listen med medlemmer er blevet en mindre efter vi sletter et medlem
        assertEquals(listBefore, listAfter + 1);
    }

    /**
     * Test of getMedlemPåNavn method, of class Controller.
     */
    @Test
    public void testGet2MedlemPåNavn() {
        String name = "Frederik";
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200, false, "noget@andet.dk");
        c.opretMotionist("Hans", 10, 10, true, "hans@gmail.com");
        int expResult = 2;
        ArrayList result = c.getMedlemPåNavn(name);
        //Vi opretter 3 medlemmer, men forventer kun at få 2 ud når vi søger på navnet Frederik
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getMedlemPåCprnr method, of class Controller.
     */
    @Test
    public void testGetMedlemPåCprnr(){
        int cprnr = 1912891867;
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200, false, "noget@andet.dk");
        c.opretMotionist("Hans", 10, 10, true, "hans@gmail.com");
        String expResult = new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com").getMail();
        String result = c.getMedlemPåCprnr(cprnr).getMail();
        //Vi søger på cpr nr, og tjekker om vi har fundet den rigtige ved at sammenligne mails
        assertEquals(expResult, result);
    }

    /**
     * Test of getMedlemPåMail method, of class Controller.
     */
    @Test
    public void testGetMedlemPåMail() {
        String mail = "frederiket@gmail.com";
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Frederik", 100200, 100200, false, "noget@andet.dk");
        c.opretMotionist("Hans", 10, 10, true, "hans@gmail.com");
        int expResult = new Motionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com").getCprnr();
        int result = c.getMedlemPåMail(mail).getCprnr();
        //Vi søger på mail, og tjekker om vi har fundet den rigtige ved at sammenligne cprnr
        assertEquals(expResult, result);
    }

    /**
     * Test of redigerMedlem method, of class Controller.
     */
    @Test
    public void testRedigerMedlemNavn() {
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        String newName = "Hans";
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        c.redigerMedlem(c.getMedlemPåCprnr(1912891867), newName, newFødselsdato, NewMedlemskabsstatus, newMail);
        String result = c.getMedlemPåCprnr(1912891867).getName();
        //vi tjekker om der nu er et medlem med navnet Hans, m hed originalt Frederik
        assertEquals("Hans", result);
    }
    
    /**
     * Test of redigerMedlem method, of class Controller.
     */
    @Test
    public void testRedigerMedlemFødselsdato() {
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        String newName = "Hans";
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        c.redigerMedlem(c.getMedlemPåCprnr(1912891867), newName, newFødselsdato, NewMedlemskabsstatus, newMail);
        int result = c.getMedlemPåCprnr(1912891867).getFødselsår();
        //vi tjekker om fødselsdato er ændret
        assertEquals(newFødselsdato, result);
    }
    
    /**
     * Test of redigerMedlem method, of class Controller.
     */
    @Test
    public void testRedigerMedlemMedlemskabsstatus() {
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        String newName = "Hans";
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        c.redigerMedlem(c.getMedlemPåCprnr(1912891867), newName, newFødselsdato, NewMedlemskabsstatus, newMail);
        boolean result = c.getMedlemPåCprnr(1912891867).isMedlemskabsstatus();
        //vi tjekker om medlemsskabsstatus er ændret
        assertEquals(NewMedlemskabsstatus, result);
    }
    
    /**
     * Test of redigerMedlem method, of class Controller.
     */
    @Test
    public void testRedigerMedlemMail() {
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        String newName = "Hans";
        int newFødselsdato = 100200;
        boolean NewMedlemskabsstatus = false;
        String newMail = "hans@gmail.com";
        c.redigerMedlem(c.getMedlemPåCprnr(1912891867), newName, newFødselsdato, NewMedlemskabsstatus, newMail);
        String result = c.getMedlemPåCprnr(1912891867).getMail();
        //vi tjekker om mail er ændret
        assertEquals(newMail, result);
    }
    
    /**
     * Test of opretResultat method, of class Controller.
     */
    @Test
    public void testOpret1Resultat() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        int resultaterFør = c.getMedlemPåCprnr(1912891867).getResultater().size();
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        int resultaterEfter = c.getMedlemPåCprnr(1912891867).getResultater().size();
        //vi tjekker om listen af medlemmets resultater er en større efter vi har oprettet et resultat
        assertEquals(resultaterFør, resultaterEfter - 1);
    }

    /**
     * Test of getKonkurrencesvømmerPåCprnr method, of class Controller.
     */
    @Test
    public void testGetKonkurrencesvømmerPåCprnrByCheckingMail() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        int cprnr = 1912891867;
        String expResult = "frederiket@gmail.com";
        String result = c.getKonkurrencesvømmerPåCprnr(cprnr).getMail();
        //vi tjekker om vi finder den rigtigt person når vi søger på cprnr ved at se om mailen passer
        assertEquals(expResult, result);
    }

    /**
     * Test of setTrænernavn method, of class Controller.
     */
    @Test
    public void testSetTrænernavn() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        String trænernavn = "Talha";
        c.setTrænernavn(c.getKonkurrencesvømmerPåCprnr(1912891867), trænernavn);
        String result = c.getKonkurrencesvømmerPåCprnr(1912891867).getTrænernavn();
        String expResult = "Talha";
        //vi tjekker om trænernavnet blev ændret til Talha
        assertEquals(expResult, result);
    }

    /**
     * Test of søgAlleResultater method, of class Controller.
     */
    @Test
    public void testGetAlle6Resultater() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        int expResult = 6;
        int result = c.getAlleResultater().size();
        //vi tjekker om arrayet med resultater har størrelsen 6 efter vi har oprettet 6 resultater
        assertEquals(expResult, result);
    }

    /**
     * Test of søgCrawlResultater method, of class Controller.
     */
    @Test
    public void testGet2CrawlResultater() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 2;
        int result = c.getCrawlResultater().size();
        //vi opretter forskellige resultater og tjekker om vi kun får crawlresultaterne returned
        assertEquals(expResult, result);
    }

    /**
     * Test of søgRygrawlResultater method, of class Controller.
     */
    @Test
    public void testGet1RygrawlResultater() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 1;
        int result = c.getRygrawlResultater().size();
        //vi opretter forskellige resultater og tjekker om vi kun får rygcrawlresultaterne returned
        assertEquals(expResult, result);
    }

    /**
     * Test of søgButterflyResultater method, of class Controller.
     */
    @Test
    public void testGet2ButterflyResultater() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 2;
        int result = c.getButterflyResultater().size();
        //vi opretter forskellige resultater og tjekker om vi kun får butterflyresultaterne returned
        assertEquals(expResult, result);
    }

    /**
     * Test of søgBrystsvømningResultater method, of class Controller.
     */
    @Test
    public void testGet1BrystsvømningResultater() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 1;
        int result = c.getBrystsvømningResultater().size();
        //vi opretter forskellige resultater og tjekker om vi kun får brystsvømningsresultaterne returned
        assertEquals(expResult, result);

    }

    /**
     * Test of getTop5 method, of class Controller.
     */
    @Test
    public void testGetTop5Resultater2Crawl() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        int expResult = 2;
        int result = c.getTop5(Disciplin.CRAWL).size();
        //vi opretter resultater af forskellige discipliner og tjekker om antallet af resultater vi får returned stemmer overens med antallet af crawlresultater
        assertEquals(expResult, result);       
    }
    
    /**
     * Test of getTop5 method, of class Controller.
     */
    @Test
    public void testGetTop5Resultater5Brystsvømning() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        int expResult = 5;
        int result = c.getTop5(Disciplin.BRYSTSVØMNING).size();
        //vi opretter resultater og tjekker om antallet af resultater vi får returned holder sig inden inden for en top 5.
        assertEquals(expResult, result);       
    }
    /**
     * Test of getRestanceForMedlem method, of class Controller.
     */
    @Test
    public void testGetRestanceForMedlem1ÅrJunior1ÅrVoksen() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2005, false);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2006, true);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2007, false);
        c.opretBetaling(c.getKonkurrencesvømmerPåCprnr(1912891867), 2008, true);
        int expResult = 2600;
        int result = c.getRestanceForMedlem(c.getKonkurrencesvømmerPåCprnr(1912891867));
        //vi forventer at han skal betale 1000kr i 2005 fordi han er under 18 og 1600 i 2007 fordi han der er 18, 2600 ialt
        assertEquals(expResult, result);
    }

    /**
     * Test of getMedlemmerIRestance method, of class Controller.
     */
    @Test
    public void testGet2MedlemmerIRestance() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, false);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, false);
        int expResult = 2;
        int result = c.getMedlemmerIRestance().size();
        //vi opretter 3 medlemmer og giver 2 af dem en betaling de ikke har betalt, så vi forventer at der er 2 medlemmer i restance
        assertEquals(expResult, result);

    }

    /**
     * Test of getRestanceForYear method, of class Controller.
     */
    @Test
    public void testGetRestanceForYear() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, false);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, false);
        int year = 2004;
        int expResult = 2000;
        int result = c.getRestanceForYear(year);
        //vi opretter 3 medlemmer med en betaling i 2004, 2 af dem har ikke betalt og er begge under 18 år, så vi forventer at restancen for det år er 2000
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getRestanceForYear method, of class Controller.
     */
    @Test
    public void testGetZeroRestanceForYear() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, true);
        int year = 2004;
        int expResult = 0;
        int result = c.getRestanceForYear(year);
        //vi tester om restancen er 0
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getForventetIndkomstFraKontingenter method, of class Controller.
     */
    @Test
    public void testGetForventetIndkomstFraKontingenter() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        c.opretBetaling(c.getMedlemPåCprnr(1011891867), 2004, false);
        c.opretBetaling(c.getMedlemPåCprnr(1212891867), 2004, false);
        int year = 2004;
        int expResult = 3000;
        int result = c.getForventetIndkomstFraKontingenter(year);
        //vi opretter 3 medlemmer med betalinger i 2004, en er betalt og 2 er ikke, vi forventer den samlede indkomst burde være 3000 da alle 3 er under 18
        assertEquals(expResult, result);

    }

    /**
     * Test of getMedlemmerListe method, of class Controller.
     */
    @Test
    public void testGetMedlemmerListe() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        int expResult = 3;
        int result = c.getMedlemmerListe().size();
        //vi opretter 3 medlemmer og forventer at arrayet med medlemmer har en størrelse på 3
        assertEquals(expResult, result);
    }



    /**
     * Test of sletResultat method, of class Controller.
     */
    @Test
    public void testSletResultat() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "hej", Disciplin.CRAWL, "hej", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/2/2004", Disciplin.CRAWL, "hej", 0);
        int resultaterFør = c.getKonkurrencesvømmerPåCprnr(1912891867).getResultater().size();
        Resultat r = c.getKonkurrencesvømmerPåCprnr(1912891867).getResultater().get(0);
        c.sletResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), r);
        int resultaterEfter = c.getKonkurrencesvømmerPåCprnr(1912891867).getResultater().size();
        //vi opretter 2 resultater og sletter 1, og tjekker om arrayet med resultater efterfølgende er 1 mindre
        assertEquals(resultaterFør, resultaterEfter+1);
    }

    /**
     * Test of getDisciplinResultater method, of class Controller.
     */
    @Test
    public void testGetDisciplinResultaterBrystsvømning() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 200, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.CRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 100, "10/10/1999", Disciplin.RYGCRAWL, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 500, "10/10/1999", Disciplin.BRYSTSVØMNING, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 700, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        c.opretResultat(c.getKonkurrencesvømmerPåCprnr(1912891867), 300, "10/10/1999", Disciplin.BUTTERFLY, "randerssRegnskov", 0);
        Disciplin disciplin = Disciplin.BRYSTSVØMNING;
        int expResult = 1;
        int result = c.getDisciplinResultater(disciplin).size();
        //vi opretter nogle resultater og tjekker om vi kun får dem der er brystsvømning returned
        assertEquals(expResult, result);

    }

    /**
     * Test of getKonkurrencesvømmere method, of class Controller.
     */
    @Test
    public void testGet2Konkurrencesvømmere() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretKonkurrencesvømmer("Talha", 1011891867, 1989, true, "frederiket@gmail.com");
        c.opretMotionist("Sebastian", 1212891867, 1989, true, "frederiket@gmail.com");
        int expResult = 2;
        int result = c.getKonkurrencesvømmere().size();
        //vi opretter 3 svømmere, hvoraf 2 er konkurrencesvømmere, så vi tjekker om vi kun får returned konkurrencesvømmere ved at se på antallet
        assertEquals(expResult, result);
    }

    /**
     * Test of getBestResult method, of class Controller.
     */
    @Test
    public void testGetBestResultButterfly() {
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
        //vi opretter forskellige resultater, vi tjekker om vi får det bedste butterfly resultat tilbage,
        //ved at sammenligne tiden med det bedste butterfly resultat vi oprettede
        assertEquals(expResult, result);
    }

    /**
     * Test of timeFormatter method, of class Controller.
     */
    @Test
    public void testTimeFormatter126Sec() {
        int time = 126;
        String expResult = "02:06";
        String result = c.timeFormatter(time);
        //vi tjekker om 126 sec bliver lavet om til en string af formattet "mm:ss"
        assertEquals(expResult, result);
    }

    /**
     * Test of getBetalingByYear method, of class Controller.
     */
    @Test
    public void testGetBetalingByYear2004() {
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, true);
        System.out.println(c.getMedlemPåCprnr(1912891867).getBetalinger());
        int year = 2004;
        int expResult = 1;
        int result = c.getBetalingByYear(c.getMedlemPåCprnr(1912891867), year).getId();
        //vi opretter en betaling for 2004 og tjekker om vi får den rigtigt betaling ved at søge på id,
        //id'et 1 fordi der er den første betaling vi opretter, og betaling 0 bliver opretter sammen med medlemmet
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
        //expResult er 6 fordi medlemmer automatisk får deres første betaling når de bliver oprettet
        int expResult = 6;
        int result = c.getAlleBetalinger().size();
        //vi opretter 4 betalinger og 2 medlemmer, atlså forventer vi 6 betalinger ialt
        assertEquals(expResult, result);
    }

    /**
     * Test of opretBetaling method, of class Controller.
     */
    @Test
    public void testOpretBetaling() {
        System.out.println("opretBetaling");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        int betalingerFør = c.getMedlemPåCprnr(1912891867).getBetalinger().size();
        int betalingsyear = 2004;
        boolean hasPaid = false;      
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), betalingsyear, hasPaid);
        int betalingerEfter = c.getMedlemPåCprnr(1912891867).getBetalinger().size();
        //vi opretter en betaling og tjekker om arrayet med betalinger er belevet 1 større efterfølgende
        assertEquals(betalingerFør, betalingerEfter - 1);
    }

    /**
     * Test of redigerBetaling method, of class Controller.
     */
    @Test
    public void testRedigerBetalingFraFalseTilTrue() {
        System.out.println("redigerBetaling");
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        c.opretBetaling(c.getMedlemPåCprnr(1912891867), 2004, false);
        Betaling betaling = c.getMedlemPåCprnr(1912891867).getBetalinger().get(1);
        boolean betalingFør = betaling.isHasPaid();
        boolean isPaid = true;
        c.redigerBetaling(betaling, isPaid);
        boolean betalingEfter = betaling.isHasPaid();
        //vi redigere en betaling og tjekker om isPaid, der før var false ikke er det samme længere
        assertNotEquals(betalingFør, betalingEfter);
    }
}
