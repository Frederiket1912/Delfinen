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
        System.out.println(dao.getMedlemmer());  
    }
    
}
