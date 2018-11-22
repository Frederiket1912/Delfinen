package delfinen.data;

import java.util.ArrayList;


public interface Medlem {

    public ArrayList<Betaling> getBetalinger(); 
    
    public Aktivitetsform getAktivitetsform();

    public void setBetalinger(Betaling betaling);

    @Override
    public String toString();

    public void setFødselsår(int fødselsdato);

    public int getFødselsår();
    
    public String getName();

    public void setName(String name);

    public int getCprnr();

    public boolean isMedlemskabsstatus();

    public void setMedlemskabsstatus(boolean medlemskabsstatus);

    public String getMail();

    public void setMail(String mail);
    
    public ArrayList<Resultat> getResultater();
}
