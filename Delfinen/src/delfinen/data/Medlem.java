/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.Betaling;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public interface Medlem {

    public ArrayList<Betaling> getBetalinger(); 
    
    public boolean isAktivitetsform();

    public void setBetalinger(Betaling betaling);

    @Override
    public String toString();

    public void setFødselsdato(int fødselsdato);

    public int getFødselsdato();
    
    public String getName();

    public void setName(String name);

    public int getCprnr();

    public boolean isMedlemskabsstatus();

    public void setMedlemskabsstatus(boolean medlemskabsstatus);

    public String getMail();

    public void setMail(String mail);
    
    public ArrayList<Resultat> getResultater();
}
