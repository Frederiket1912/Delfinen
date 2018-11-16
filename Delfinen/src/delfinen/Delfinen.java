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
        Resultat r1 = new Resultat(100, "10/10/1999", Disciplin.CRAWL, null, 0);
        Resultat r2 = new Resultat(200, "10/10/1999", Disciplin.CRAWL, null, 0);
        ArrayList<Betaling> betalinger = new ArrayList();
        ArrayList<Resultat> resultater = new ArrayList();
        Konkurrencesvømmer ks = new Konkurrencesvømmer("Frederik", 1912891967, true, "frederiket@gmail.com", betalinger, 0, resultater, "Henrik");
        
        Medlem m = c.søgMedlemPåCprnr(1912891867);
        c.opretKonkurrencesvømmer("Frederik", 1912891867, true, "frederiket@gmail.com", betalinger, 0, resultater, "Henrik");
        c.opretResultat(ks, 200, "10/10/1999", Disciplin.CRAWL, null, 0);
        c.opretResultat(ks, 100, "10/10/1999", Disciplin.CRAWL, null, 0);
        System.out.println(ks.getResultater());
        System.out.println(c.getMedlemmer());
        System.out.println(m);
        System.out.println(m.getResultater());
        System.out.println(c.getTop5(Disciplin.CRAWL));
    }
    
}
