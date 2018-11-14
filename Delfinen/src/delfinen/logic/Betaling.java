package delfinen.logic;

import delfinen.data.Medlem;
import delfinen.data.Kontingent;

public class Betaling {

    private int year;

    public Betaling() {

    }
        // hent priser fra kontingent når de er lavet, istedet for at hardcode.
    public int udregnBetaling(Medlem medlem, int year) {
        int age;
        age = year - medlem.getFødselsdato();
        Kontingent k = new Kontingent();
        if (medlem.isMedlemskabsstatus()) {
            if (age < 18) {
                return k.getJuniorPris();
            }
            if (age >= 18) {
                return k.getVoksenPris();
            }
            if (age >= 60) {
                return k.getSeniorPris();
            }
        }
        return k.getPassivPris();
    }
}
