
package delfinen.data;

import delfinen.logic.BetalingCalculator;
import delfinen.logic.Controller;


public class Resultat implements Comparable<Resultat>{
    private int timeInSeconds;
    private String date;
    private Disciplin disciplin;
    private String competitionName;
    private int placement;
    private String name;
    private int id;

    public Resultat(int timeInSeconds, String date, Disciplin disciplin, String competitionName, int placement, Konkurrencesvømmer konkurrencesvømmer) {
        this.timeInSeconds = timeInSeconds;
        this.date = date;
        this.disciplin = disciplin;
        this.competitionName = competitionName;
        this.placement = placement;
        this.name = konkurrencesvømmer.getName();
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Resultat{" + "timeInSeconds=" + timeInSeconds + ", date=" + date + ", disciplin=" + disciplin + ", competitionName=" + competitionName + ", placement=" + placement + '}';
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public Disciplin getDisciplin() {
        return disciplin;
    }

    @Override
    public int compareTo(Resultat o) {
        return (this.timeInSeconds - o.timeInSeconds);
    }
    
    
}
