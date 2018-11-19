
package delfinen.data;

import delfinen.logic.BetalingCalculator;


public class Betaling {
    
    private int year;
    private int betalingssum;
    private int betalingsyear;
    private boolean hasPaid;
    
    public Betaling(Medlem medlem, int betalingsyear, boolean hasPaid) {
        BetalingCalculator bc = new BetalingCalculator();
        this.betalingssum = bc.udregnBetaling(medlem, betalingsyear);
        this.betalingsyear = betalingsyear;
        this.hasPaid = hasPaid;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
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
