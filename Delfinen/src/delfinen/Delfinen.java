/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Konkurrencesvømmer;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
import delfinen.data.Resultat;
import delfinen.logic.Betaling;
import delfinen.logic.Controller;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class Delfinen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Controller c = new Controller(new DataAccessorFile());

        ArrayList<Betaling> betalinger = new ArrayList();
        ArrayList<Resultat> resultater = new ArrayList(); 
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 0, true, "frederiket@gmail.com", betalinger, resultater, "Henrik");
        //Medlem m = c.søgMedlemPåCprnr(1912891867);
        Konkurrencesvømmer m = c.søgKonkurrencesvømmerPåCprnr(1912891867);
        System.out.println(m);
        c.opretResultat(m, 200, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 100, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 100, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 500, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 700, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 300, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 600, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 600, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 600, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 600, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(m, 600, "10/10/1999", Disciplin.CRAWL, null, 0);
        System.out.println(m.getResultater());
        System.out.println(c.getTop5(Disciplin.CRAWL));
    }
    
}
