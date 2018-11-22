/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.data.Betaling;
import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Konkurrencesvømmer;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
import delfinen.data.Resultat;
import delfinen.logic.BetalingCalculator;
import delfinen.logic.Controller;
import java.time.LocalDate;
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
        Controller c = new Controller(new DataAccessorFile(), new BetalingCalculator());
        c.opretKonkurrencesvømmer("Frederik", 1912891867, 1989, true, "frederiket@gmail.com");
        Konkurrencesvømmer m = c.getKonkurrencesvømmerPåCprnr(1912891867);
        c.opretBetaling(m, 2000, true);
        System.out.println(m.getBetalinger());
        c.opretBetaling(m, 2001, true);
        System.out.println(m.getBetalinger());
        c.opretBetaling(m, 2002, true);
        System.out.println(m.getBetalinger());
        
        System.out.println("RESULTATER:");
        c.opretResultat(m, 100, "10", Disciplin.CRAWL, "hej", 1);
        System.out.println(m.getResultater());
        c.opretResultat(m, 100, "10", Disciplin.CRAWL, "hej", 1);
        System.out.println(m.getResultater());
        
        c.opretResultat(m, 100, "10", Disciplin.CRAWL, "hej", 1);
        System.out.println(m.getResultater());

    }
    
}
