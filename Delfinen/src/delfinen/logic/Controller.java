/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.DataAccessorFile;
import delfinen.data.Medlem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Context.DEBUG;

public class Controller {
    private ArrayList<Medlem> alleMedlemmer = new ArrayList<>();
    private DataAccessorFile dao;

    public Controller(DataAccessorFile dao) {
        this.dao = dao;
    }
    
    
    public ArrayList<Medlem> getMedlemmer() {
        try {
            alleMedlemmer = dao.læsFil();
        }   catch (ClassNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } 
        return alleMedlemmer;
    }
    
    public void opretMedlem(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) throws ClassNotFoundException {
            Medlem m = new Medlem(name, cprnr, fødselsdato, medlemskabsstatus, mail);
            alleMedlemmer.add(m);
            dao.skrivTilFil(alleMedlemmer);
        
    }
    
    public void sletMedlem(Medlem medlem) throws ClassNotFoundException {
        ArrayList<Medlem> fjernes = new ArrayList();
            for (Medlem m : alleMedlemmer) {
                if (m.getCprnr() == medlem.getCprnr()) {
                    fjernes.add(m);  
                }
            }
            alleMedlemmer.removeAll(fjernes);
            dao.skrivTilFil(alleMedlemmer);                    
    }
    
    public ArrayList<Medlem> søgMedlemPåNavn(String name) throws ClassNotFoundException {
        ArrayList<Medlem> medlemmerMedNavn = new ArrayList();
            for (Medlem m : alleMedlemmer) {
                if (m.getName().contains(name)) {
                    medlemmerMedNavn.add(m);
                }
            }
        return medlemmerMedNavn;
    }
    
    public Medlem søgMedlemPåCprnr(int cprnr) {
        Medlem result = null;
            for (Medlem m : getMedlemmer()) {
                if (m.getCprnr() == cprnr) {
                    result = m;
                    return result;
                }
            } 
        return result;
    }
    
    public Medlem søgMedlemPåMail(String mail) {
        Medlem result = null;
            for (Medlem m : getMedlemmer()) {
                if (m.getMail().contains(mail)) {
                    result = m;
                    return result;
                }
            }
        return result;
    }
    
    public void redigerMedlem(Medlem medlem, String newName, int newFødselsdato, boolean NewMedlemskabsstatus, String newMail) {
            for (Medlem m : alleMedlemmer) {
                if (m.getCprnr() == medlem.getCprnr()) {
                    m.setName(newName);
                    m.setFødselsdato(newFødselsdato);
                    m.setMedlemskabsstatus(NewMedlemskabsstatus);
                    m.setMail(newMail);
                }
            }
            dao.skrivTilFil(alleMedlemmer);
    }
}

