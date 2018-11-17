/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.Aktivitetsform;
import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Konkurrencesvømmer;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
import delfinen.data.Resultat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        } catch (ClassNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return alleMedlemmer;
    }

    public void opretMotionist(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) throws ClassNotFoundException {
        Medlem m = new Motionist(name, cprnr, fødselsdato, medlemskabsstatus, mail);
        alleMedlemmer.add(m);
        dao.skrivTilFil(alleMedlemmer);

    }

    public void opretKonkurrencesvømmer(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail, ArrayList<Betaling> betalinger, ArrayList<Resultat> resultater, String trænernavn) {
        Medlem m = new Konkurrencesvømmer(name, cprnr, fødselsdato, medlemskabsstatus, mail, betalinger, resultater, trænernavn);
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
        for (Medlem m : alleMedlemmer) {
            if (m.getCprnr() == cprnr) {
                result = m;
                return result;
            }
        }
        return result;
    }

    public Konkurrencesvømmer søgKonkurrencesvømmerPåCprnr(int cprnr) {
        Konkurrencesvømmer result = null;
        for (Medlem m : alleMedlemmer) {
            if (m.getAktivitetsform() == Aktivitetsform.KONKURRENCESVØMMER && m.getCprnr() == cprnr){
                result = (Konkurrencesvømmer) m;
            }
        }return result;
    }

    public Medlem søgMedlemPåMail(String mail) {
        Medlem result = null;
        for (Medlem m : alleMedlemmer) {
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

    public void opretResultat(Konkurrencesvømmer konkurrencesvømmer, int timeInSeconds, String date, Disciplin disciplin, String competitionName, int placement) {
        Resultat r = new Resultat(timeInSeconds, date, disciplin, competitionName, placement);
        konkurrencesvømmer.setResultater(r);
    }

    public void setTrænernavn(Konkurrencesvømmer konkurrencesvømmer, String trænernavn) {
        konkurrencesvømmer.setTrænernavn(trænernavn);
    }

    public ArrayList<Resultat> søgAlleResultater() {
        ArrayList<Resultat> alleResultater = new ArrayList();
        for (Medlem m : alleMedlemmer) {
            ArrayList<Resultat> resultater = new ArrayList();
            resultater = m.getResultater();
            alleResultater.addAll(resultater);
        }
        return alleResultater;
    }

    public ArrayList<Resultat> søgCrawlResultater() {
        ArrayList<Resultat> crawlResultater = new ArrayList();
        for (Resultat r : søgAlleResultater()) {
            if (r.getDisciplin() == Disciplin.CRAWL) {
                crawlResultater.add(r);
            }
        }
        return crawlResultater;
    }
    
    public ArrayList<Resultat> søgRygrawlResultater() {
        ArrayList<Resultat> rygcrawlResultater = new ArrayList();
        for (Resultat r : søgAlleResultater()) {
            if (r.getDisciplin() == Disciplin.RYGCRAWL) {
                rygcrawlResultater.add(r);
            }
        }
        return rygcrawlResultater;
    }
    
    public ArrayList<Resultat> søgButterflyResultater() {
        ArrayList<Resultat> butterflyResultater = new ArrayList();
        for (Resultat r : søgAlleResultater()) {
            if (r.getDisciplin() == Disciplin.CRAWL) {
                butterflyResultater.add(r);
            }
        }
        return butterflyResultater;
    }
    
    public ArrayList<Resultat> søgBrystsvømningResultater() {
        ArrayList<Resultat> brystsvømningResultater = new ArrayList();
        for (Resultat r : søgAlleResultater()) {
            if (r.getDisciplin() == Disciplin.CRAWL) {
                brystsvømningResultater.add(r);
            }
        }
        return brystsvømningResultater;
    }
    
    public ArrayList<Resultat> getTop5(Disciplin disciplin){
        ArrayList<Resultat> disciplinResultater = new ArrayList();
        ArrayList<Resultat> top5DisciplinResultater = new ArrayList();
        for (Resultat r : søgAlleResultater()) {
            if (r.getDisciplin() == disciplin){
                disciplinResultater.add(r);
            }
        }
        Collections.sort(disciplinResultater);
        for (int i = 0; i < 5; i++) {
            top5DisciplinResultater.add(disciplinResultater.get(i));
        }
        return top5DisciplinResultater;
    }
}

