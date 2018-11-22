package delfinen.data;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of skrivTilFil method, of class DataAccessorFile.
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSkrivTilFil() throws ClassNotFoundException {
        File file = new File("Medlemmer.txt");
        long fileBefore = file.length();
        ArrayList<Medlem> alleMedlemmer = new ArrayList();
        DataAccessorFile instance = new DataAccessorFile();
        Motionist m = new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        alleMedlemmer.add(m);
        instance.skrivTilFil(alleMedlemmer);
        long fileAfter = file.length();
        //vi skriver et tomt array tilbage til filen, ellers virker testen kun første gang
        alleMedlemmer.clear();
        instance.skrivTilFil(alleMedlemmer);
        //vi tjekker om filen har ændret størrelse efter vi har skrevet til den
        assertNotEquals(fileBefore, fileAfter);
    }

    /**
     * Test of læsFil method, of class DataAccessorFile.
     * @throws java.lang.Exception
     */
    @Test
    public void testLæsFil() throws Exception {
        DataAccessorFile instance = new DataAccessorFile();
        ArrayList<Medlem> alleMedlemmer = new ArrayList();
        Motionist m = new Motionist("Frederik", 1912891867, 19121989,true,"frederiket@gmail.com");
        alleMedlemmer.add(m);
        instance.skrivTilFil(alleMedlemmer);
        ArrayList<Medlem> result = instance.læsFil();
        //vi skriver et tomt array tilbage til filen, ellers virker testen kun første gang
        alleMedlemmer.clear();
        instance.skrivTilFil(alleMedlemmer);
        //vi forventer at det array vi får ud har et object
        assertEquals(1, result.size());
    }
    
}
