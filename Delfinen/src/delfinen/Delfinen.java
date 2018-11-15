/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.data.DataAccessorFile;
import delfinen.data.Medlem;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class Delfinen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataAccessorFile dao = new DataAccessorFile();
        dao.opretMedlem("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        dao.opretMedlem("Thomas", 1968, 100200, true, "noget@andet.dk");
        System.out.println(dao.getMedlemmer().size());
        Medlem m = new Medlem("Hans", 0, 0, true, "mail");
        dao.opretMedlem(m.getName(),m.getCprnr(),m.getFødselsdato(),m.isMedlemskabsstatus(),m.getMail());
        System.out.println(dao.getMedlemmer().size());
        //dao.sletMedlem(m);
        System.out.println(dao.getMedlemmer().size());
        System.out.println(dao.søgMedlemPåMail("frederiket@gmail.com"));
        dao.redigerMedlem3(m, "Kalle", 100200, 100200, false, "kalle@gmail.com");
        System.out.println(dao.getMedlemmer().size());
        System.out.println(dao.søgMedlemPåNavn("Kalle"));
        System.out.println(dao.søgMedlemPåNavn("Hans"));
    }
    
}
