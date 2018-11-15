package delfinen.logic;

import delfinen.data.Medlem;


public class Betaling {
    final static int PASSIVPRIS = 500;
    final static int JUNIORPRIS = 1000;
    final static int VOKSENPRIS = 1600;
    final static int SENIORPRIS = 1200;
    private int year;

    public Betaling() {

    }
        // hent priser fra kontingent når de er lavet, istedet for at hardcode.
    public int udregnBetaling(Medlem medlem, int year) {
        int age;
        age = year - medlem.getFødselsdato();
        if (medlem.isMedlemskabsstatus()) {
            if (age < 18) {
                return JUNIORPRIS;
            }
            if (age >= 18 && age < 60) {
                return VOKSENPRIS;
            }
            if (age >= 60) {
                return SENIORPRIS;
            }
        }
        return PASSIVPRIS;
    }
}
