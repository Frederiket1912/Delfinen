package delfinen.logic;

import delfinen.data.Medlem;

public class Betaling {

    private int year;

    public Betaling() {

    }

    public int udregnBetaling(Medlem medlem, int year) {
        int age;
        age = medlem.getFødselsdato() - year;

        if (medlem.isMedlemskabsstatus()) {
            if (age < 18) {
                return 1000;
            }
            if (age >= 18) {
                return 1600;
            }
            if (age >= 60) {
                return 1200;
            }
        }
        return 500;
    }
}
