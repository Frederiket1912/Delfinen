package delfinen.data;

import java.io.Serializable;


public class Resultat implements Comparable<Resultat>, Serializable{
    private int timeInSeconds;
    private String date;
    private Disciplin disciplin;
    private String competitionName;
    private int placement;
    private String name;
    private int id;
    private int CPR;

    public Resultat(int timeInSeconds, String date, Disciplin disciplin, String competitionName, int placement, Konkurrencesvømmer konkurrencesvømmer) {
        this.timeInSeconds = timeInSeconds;
        this.date = date;
        this.disciplin = disciplin;
        this.competitionName = competitionName;
        this.placement = placement;
        this.name = konkurrencesvømmer.getName();
        this.CPR = konkurrencesvømmer.getCprnr();
    }

    public int getCPR() {
        return CPR;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public Disciplin getDisciplin() {
        return disciplin;
    }
    public int getPlacement(){
        return this.placement;
    }

    @Override
    public int compareTo(Resultat o) {
        return (this.timeInSeconds - o.timeInSeconds);
    }
    
    
}
