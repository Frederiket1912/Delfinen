package delfinen.logic;

import delfinen.data.Medlem;


public class Betaling {
    final private int passivPris = 500;
    final private int juniorPris = 1000;
    final private int voksenPris = 1600;
    final private int seniorPris = 1200;
    private int year;

    public Betaling() {

    }
        // hent priser fra kontingent når de er lavet, istedet for at hardcode.
    public int udregnBetaling(Medlem medlem, int year) {
        int age;
        age = year - medlem.getFødselsdato();
        if (medlem.isMedlemskabsstatus()) {
            if (age < 18) {
                return juniorPris;
            }
            if (age >= 18 && age < 60) {
                return voksenPris;
            }
            if (age >= 60) {
                return seniorPris;
            }
        }
        return passivPris;
    }
}
