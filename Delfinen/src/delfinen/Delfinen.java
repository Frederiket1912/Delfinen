/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.data.DataAccessorFile;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
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
        c.opretMotionist("Frederik", 1912891867, 19121989, true, "frederiket@gmail.com");
        c.opretMotionist("Thomas", 1968, 100200, true, "noget@andet.dk");
        System.out.println(c.getMedlemmer().size());
        Medlem m = new Motionist("Hans", 0, 0, true, "mail");
        c.opretMotionist(m.getName(),m.getCprnr(),m.getFødselsdato(),m.isMedlemskabsstatus(),m.getMail());
        System.out.println(c.getMedlemmer().size());
        //dao.sletMedlem(m);
        System.out.println(c.getMedlemmer().size());
        System.out.println(c.søgMedlemPåMail("frederiket@gmail.com"));
        c.redigerMedlem(m, "Kalle", 100200, true, "kalle@gmail.com");
        System.out.println(c.getMedlemmer().size());
        System.out.println(c.søgMedlemPåNavn("Kalle"));
        System.out.println(c.søgMedlemPåNavn("Hans"));
    }
    
}
