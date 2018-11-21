
package delfinen.data;

import delfinen.logic.BetalingCalculator;
import delfinen.logic.Controller;
import java.io.Serializable;


public class Betaling implements Serializable {
    
    private int year;
    private int betalingssum;
    private int betalingsyear;
    private boolean hasPaid;
    private int id;

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
        Controller c = new Controller(new DataAccessorFile(), new BetalingCalculator());
        int counter = -1;
        if (c.getAlleResultater().size() == 0){
            this.id = 0;
        }
        else {
            for (Resultat r : c.getAlleResultater()){
                if (r.getId() > counter){
                    counter = r.getId() + 1;
                }
            }
            this.id = counter;
        }
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
