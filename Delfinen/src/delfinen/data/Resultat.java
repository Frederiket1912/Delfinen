
package delfinen.data;


public class Resultat implements Comparable<Resultat>{
    private int timeInSeconds;
    private String date;
    private Disciplin disciplin;
    private String competitionName;
    private int placement;

    public Resultat(int timeInSeconds, String date, Disciplin disciplin, String competitionName, int placement) {
        this.timeInSeconds = timeInSeconds;
        this.date = date;
        this.disciplin = disciplin;
        this.competitionName = competitionName;
        this.placement = placement;
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
