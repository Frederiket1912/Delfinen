
package delfinen.data;

import delfinen.logic.Betaling;
import java.io.Serializable;
import java.util.ArrayList;


public class Konkurrencesvømmer implements Serializable, Medlem {
    private String name;
    private int cprnr;
    private boolean medlemskabsstatus;
    private String mail;
    private ArrayList<Betaling> betalinger;
    private int fødselsdato;
    private ArrayList<Resultat> resultater;
    private String trænernavn;
    private boolean aktivitetsform = true;

    public boolean isAktivitetsform() {
        return aktivitetsform;
    }

    

    public Konkurrencesvømmer(String name, int cprnr, boolean medlemskabsstatus, String mail, ArrayList<Betaling> betalinger, int fødselsdato, ArrayList<Resultat> resultater, String trænernavn) {
        this.name = name;
        this.cprnr = cprnr;
        this.medlemskabsstatus = medlemskabsstatus;
        this.mail = mail;
        this.betalinger = betalinger;
        this.fødselsdato = fødselsdato;
        this.resultater = resultater;
        this.trænernavn = trænernavn;
    }

    @Override
    public String toString() {
        return "Konkurrencesv\u00f8mmer{" + "name=" + name + ", cprnr=" + cprnr + ", medlemskabsstatus=" + medlemskabsstatus + ", mail=" + mail + ", betalinger=" + betalinger + ", f\u00f8dselsdato=" + fødselsdato + ", resultater=" + resultater + ", tr\u00e6nernavn=" + trænernavn + '}';
    }

    public ArrayList<Resultat> getResultater() {
        return resultater;
    }
    
    public void setResultater(Resultat resultat) {
        resultater.add(resultat);
    }

    public String getTrænernavn() {
        return trænernavn;
    }

    public void setTrænernavn(String trænernavn) {
        this.trænernavn = trænernavn;
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
    public void setFødselsdato(int fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    @Override
    public int getFødselsdato() {
        return fødselsdato;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCprnr() {
        return cprnr;
    }

    @Override
    public boolean isMedlemskabsstatus() {
        return medlemskabsstatus;
    }

    @Override
    public void setMedlemskabsstatus(boolean medlemskabsstatus) {
        this.medlemskabsstatus = medlemskabsstatus;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
