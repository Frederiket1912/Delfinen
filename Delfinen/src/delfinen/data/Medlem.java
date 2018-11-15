
package delfinen.data;

import delfinen.logic.Betaling;
import java.io.Serializable;
import java.util.ArrayList;


public class Medlem implements Serializable {
    private ArrayList<Betaling> betalinger;
    private String name;
    private String mail;
    private int cprnr;
    private int fødselsdato;

    public ArrayList<Betaling> getBetalinger() {
        return betalinger;
    }

    public void setBetalinger(Betaling betaling) {
        betalinger.add(betaling);
    }
    private boolean medlemskabsstatus;

    @Override
    public String toString() {
        return "Medlem{" 
                + "name=" + name 
                + ", cprnr=" + cprnr 
                + ", medlemskabsstatus=" + medlemskabsstatus 
                + ", mail=" + mail 
                + ", f\u00f8dselsdato=" + fødselsdato 
                + ", betalinger=" + betalinger + '}';
    }

    

    public Medlem(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        this.name = name;
        this.cprnr = cprnr;
        this.medlemskabsstatus = medlemskabsstatus;
        this.mail = mail;
        this.fødselsdato = fødselsdato;
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

    public void setCprnr(int cprnr) {
        this.cprnr = cprnr;
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

}
