
package delfinen.data;

import delfinen.logic.BetalingCalculator;
import java.io.Serializable;
import java.util.ArrayList;


public class Konkurrencesvømmer implements Serializable, Medlem {
    private String name;
    private int cprnr;
    private boolean medlemskabsstatus;
    private String mail;
    private ArrayList<Betaling> betalinger;
    private int fødselsår;
    private ArrayList<Resultat> resultater;
    private String trænernavn;
    private Aktivitetsform aktivitetsform = Aktivitetsform.KONKURRENCESVØMMER;




    

    public Konkurrencesvømmer(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        this.name = name;
        this.cprnr = cprnr;
        this.medlemskabsstatus = medlemskabsstatus;
        this.mail = mail;
        this.betalinger = new ArrayList();
        this.fødselsår = fødselsdato;
        this.resultater = new ArrayList();
        this.trænernavn = null;
    }

    @Override
    public String toString() {
        return "Konkurrencesv\u00f8mmer{" + "name=" + name + ", cprnr=" + cprnr + ", medlemskabsstatus=" + medlemskabsstatus + ", mail=" + mail + ", betalinger=" + betalinger + ", f\u00f8dselsdato=" + fødselsår + ", resultater=" + resultater + ", tr\u00e6nernavn=" + trænernavn + '}';
    }
    public Aktivitetsform getAktivitetsform() {
        return aktivitetsform;
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
    public void setFødselsår(int fødselsår) {
        this.fødselsår = fødselsår;
    }

    @Override
    public int getFødselsår() {
        return fødselsår;
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
