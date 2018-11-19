/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.Aktivitetsform;
import delfinen.data.Betaling;
import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Konkurrencesvømmer;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
import delfinen.data.Resultat;
import java.util.ArrayList;
import java.util.Collections;
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

    public void opretMotionist(String name, int cprnr, int fødselsår, boolean medlemskabsstatus, String mail) {
        Medlem m = new Motionist(name, cprnr, fødselsår, medlemskabsstatus, mail);
        alleMedlemmer.add(m);
        dao.skrivTilFil(alleMedlemmer);

    }

    public void opretKonkurrencesvømmer(String name, int cprnr, int fødselsår, boolean medlemskabsstatus, String mail) {
        Medlem m = new Konkurrencesvømmer(name, cprnr, fødselsår, medlemskabsstatus, mail);
        alleMedlemmer.add(m);
        dao.skrivTilFil(alleMedlemmer);
    }

    public void sletMedlem(Medlem medlem) {
        ArrayList<Medlem> fjernes = new ArrayList();
        for (Medlem m : alleMedlemmer) {
            if (m.getCprnr() == medlem.getCprnr()) {
                fjernes.add(m);
            }
        }
        alleMedlemmer.removeAll(fjernes);
        dao.skrivTilFil(alleMedlemmer);
    }

    public ArrayList<Medlem> søgMedlemPåNavn(String name) {
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

    public void redigerMedlem(Medlem medlem, String newName, int newFødselsår, boolean NewMedlemskabsstatus, String newMail) {
        for (Medlem m : alleMedlemmer) {
            if (m.getCprnr() == medlem.getCprnr()) {
                m.setName(newName);
                m.setFødselsår(newFødselsår);
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
    
    public int getRestanceForMedlem(Medlem medlem){
        int restanceForMedlem = 0;
        BetalingCalculator bc = new BetalingCalculator();
        for (Betaling b : medlem.getBetalinger()){
            if (b.getBetalingssum() == 0){
                restanceForMedlem += bc.udregnBetaling(medlem, b.getBetalingsyear());
            }
        }
        return restanceForMedlem;
    }
    
    public ArrayList<Medlem> getMedlemmerIRestance(){
        ArrayList<Medlem> alleMedlemmerIRestance = new ArrayList();
        for (Medlem m : alleMedlemmer){
            if (getRestanceForMedlem(m) > 0){
                alleMedlemmerIRestance.add(m);
            }
        }
        return alleMedlemmerIRestance;
    }
    
    public int getRestanceForYear(int year){
        int totalRestanceForYear = 0;
        for (Medlem m : getMedlemmerIRestance()){
            for (Betaling b : m.getBetalinger())
                if (b.getBetalingsyear() == year){
                    totalRestanceForYear += getRestanceForMedlem(m);
                }
        }
        return totalRestanceForYear;
    }
    
    public int getForventetIndkomstFraKontingenter(int year){
        int forventetIndkomst = 0;
        BetalingCalculator bc = new BetalingCalculator();
        for (Medlem m : alleMedlemmer){
            for (Betaling b : m.getBetalinger())
                if (b.getBetalingsyear() == year){
                    forventetIndkomst += bc.udregnBetaling(m, b.getBetalingsyear());
                }
        }
        return forventetIndkomst;
    }
}

