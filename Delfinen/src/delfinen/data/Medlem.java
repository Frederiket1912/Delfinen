/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.BetalingsCalculator;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public interface Medlem {

    public ArrayList<BetalingsCalculator> getBetalinger(); 
    
    public Aktivitetsform getAktivitetsform();

    public void setBetalinger(BetalingsCalculator betaling);

    @Override
    public String toString();

    public void setFødselsår(int fødselsdato);

    public int getFødselsår();
    
    public String getName();

    public void setName(String name);

    public int getCprnr();

    public boolean isMedlemskabsstatus();

    public void setMedlemskabsstatus(boolean medlemskabsstatus);

    public String getMail();

    public void setMail(String mail);
    
    public ArrayList<Resultat> getResultater();
}
