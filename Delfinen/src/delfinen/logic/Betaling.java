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
        age = medlem.getFødselsdato() - year;
        Kontingent k = new Kontingent(1,1,1,1);
        if (medlem.isMedlemskabsstatus()) {
            if (age < 18) {
                return k.getJuniorPris();
            }
            if (age >= 18) {
                return k.getSeniorPris();
            }
            if (age >= 60) {
                return k.getVoksenPris();
            }
        }
        return k.getPassivPris();
    }
}
