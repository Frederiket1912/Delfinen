
package delfinen.data;

import delfinen.logic.Betaling;
import java.io.Serializable;
import java.util.ArrayList;


public class Motionist implements Serializable, Medlem {
    private String name;
    private int cprnr;
    private boolean medlemskabsstatus;
    private String mail;
    private ArrayList<Betaling> betalinger;
    private int fødselsdato;
    private Aktivitetsform aktivitetsform = Aktivitetsform.MOTIONIST;


    @Override
    public String toString() {
        return "Medlem{" + "name=" + name + ", cprnr=" + cprnr + ", medlemskabsstatus=" + medlemskabsstatus + ", mail=" + mail + ", betaling=" + betalinger + ", f\u00f8dselsdato=" + fødselsdato + '}';
    }

    

    public Motionist(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        this.name = name;
        this.cprnr = cprnr;
        this.medlemskabsstatus = medlemskabsstatus;
        this.mail = mail;
        this.fødselsdato = fødselsdato;
        this.betalinger = new ArrayList();
    }

    public Aktivitetsform getAktivitetsform() {
        return aktivitetsform;
    }
    
    public void setFødselsdato(int fødselsdato) {
        this.fødselsdato = fødselsdato;
    }
    

    public int getFødselsdato() {
        return fødselsdato;
    }
     

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCprnr() {
        return cprnr;
    }

    public boolean isMedlemskabsstatus() {
        return medlemskabsstatus;
    }

    public void setMedlemskabsstatus(boolean medlemskabsstatus) {
        this.medlemskabsstatus = medlemskabsstatus;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public ArrayList<Betaling> getBetalinger() {
        return betalinger;
    }

    @Override
    public void setBetalinger(Betaling betaling) {
        betalinger.add(betaling);
    }

    @Override
    public ArrayList<Resultat> getResultater() {
        ArrayList<Resultat> ingenting = new ArrayList();
        return ingenting;
    }
    
    
    

}
