package delfinen.logic;

import delfinen.data.Motionist;
import delfinen.data.Betaling;
import delfinen.data.Medlem;


public class BetalingCalculator {
    final static int PASSIVPRIS = 500;
    final static int JUNIORPRIS = 1000;
    final static int VOKSENPRIS = 1600;
    final static int SENIORPRIS = 1200;
    

    public int udregnBetaling(Medlem medlem, int year) {
        int age;
        age = year - medlem.getFødselsår();
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
