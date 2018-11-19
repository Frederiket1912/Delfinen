
package delfinen.data;

import delfinen.logic.BetalingsCalculator;


public class Betaling {
    
    private int year;
    private int betalingssum;
    private int betalingsyear;

    public Betaling(Motionist medlem, int betalingsyear) {
        BetalingsCalculator bc = new BetalingsCalculator();
        this.betalingssum = bc.udregnBetaling(medlem, betalingsyear);
        this.betalingsyear = betalingsyear;
        

    }

    public int getBetalingsyear() {
        return betalingsyear;
    }

    public int getBetalingssum() {
        return betalingssum;
    }
}
