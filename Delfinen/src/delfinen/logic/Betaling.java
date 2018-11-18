package delfinen.logic;

import delfinen.data.Motionist;


public class Betaling {
    final static int PASSIVPRIS = 500;
    final static int JUNIORPRIS = 1000;
    final static int VOKSENPRIS = 1600;
    final static int SENIORPRIS = 1200;
    private int year;
    private int betalingssum;
    private int betalingsyear;

    public Betaling(Motionist medlem, int betalingsyear) {
        this.betalingssum = udregnBetaling(medlem, betalingsyear);
        this.betalingsyear = betalingsyear;

    }

    public int getBetalingsyear() {
        return betalingsyear;
    }

    public int getBetalingssum() {
        return betalingssum;
    }

    public int udregnBetaling(Motionist medlem, int year) {
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
