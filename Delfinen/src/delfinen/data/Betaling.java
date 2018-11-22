
package delfinen.data;

import delfinen.logic.BetalingCalculator;
import java.io.Serializable;


public class Betaling implements Serializable {
    
    private int year;
    private int betalingssum;
    private int betalingsyear;
    private boolean hasPaid;
    private int id;
    private String name;
    private int CPR;

    public int getId() {
        return id;
    }
    
    public Betaling(Medlem medlem, int betalingsyear, boolean hasPaid) {
        BetalingCalculator bc = new BetalingCalculator();
        this.hasPaid = hasPaid;
        if (hasPaid == true){
            this.betalingssum = bc.udregnBetaling(medlem, betalingsyear);
        }
        else{
            this.betalingssum = 0;
        }
        this.betalingsyear = betalingsyear;
        this.name = medlem.getName();
        this.CPR = medlem.getCprnr();
    }

    public void setBetalingssum(int betalingssum) {
        this.betalingssum = betalingssum;
    }

    @Override
    public String toString() {
        return "Betaling{" + "year=" + year + ", betalingssum=" + betalingssum + ", betalingsyear=" + betalingsyear + ", hasPaid=" + hasPaid + ", id=" + id + '}';
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public int getCPR(){
        return this.CPR;
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
    

}
