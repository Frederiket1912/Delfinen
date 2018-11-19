
package delfinen.data;

import delfinen.logic.BetalingCalculator;


public class Betaling {
    
    private int year;
    private int betalingssum;
    private int betalingsyear;

    public Betaling(Medlem medlem, int betalingsyear) {
        BetalingCalculator bc = new BetalingCalculator();
        this.betalingssum = bc.udregnBetaling(medlem, betalingsyear);
        this.betalingsyear = betalingsyear;
        

    }

    public int getBetalingsyear() {
        return betalingsyear;
    }

    public int getBetalingssum() {
        return betalingssum;
    }
    
    public String toString() {
        return this.betalingssum + " " + this.betalingsyear + "";
    }
}
