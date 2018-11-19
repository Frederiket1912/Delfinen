
package delfinen.data;

import delfinen.logic.BetalingsCalculator;
import java.io.Serializable;
import java.util.ArrayList;


public class Motionist implements Serializable, Medlem {
    private String name;
    private int cprnr;
    private boolean medlemskabsstatus;
    private String mail;
    private ArrayList<BetalingsCalculator> betalinger;
    private int fødselsår;
    private Aktivitetsform aktivitetsform = Aktivitetsform.MOTIONIST;


    @Override
    public String toString() {
        return "Medlem{" + "name=" + name + ", cprnr=" + cprnr + ", medlemskabsstatus=" + medlemskabsstatus + ", mail=" + mail + ", betaling=" + betalinger + ", f\u00f8dselsdato=" + fødselsår + '}';
    }

    

    public Motionist(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        this.name = name;
        this.cprnr = cprnr;
        this.medlemskabsstatus = medlemskabsstatus;
        this.mail = mail;
        this.fødselsår = fødselsdato;
        this.betalinger = new ArrayList();
    }

    public Aktivitetsform getAktivitetsform() {
        return aktivitetsform;
    }
    
    public void setFødselsår(int fødselsår) {
        this.fødselsår = fødselsår;
    }
    

    public int getFødselsår() {
        return fødselsår;
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
    public ArrayList<BetalingsCalculator> getBetalinger() {
        return betalinger;
    }

    @Override
    public void setBetalinger(BetalingsCalculator betaling) {
        betalinger.add(betaling);
    }

    @Override
    public ArrayList<Resultat> getResultater() {
        ArrayList<Resultat> ingenting = new ArrayList();
        return ingenting;
    }
    
    
    

}
