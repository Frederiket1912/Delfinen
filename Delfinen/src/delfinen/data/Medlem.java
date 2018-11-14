
package delfinen.data;

import delfinen.logic.Betaling;
import java.io.Serializable;


public class Medlem implements Serializable {
    private String name;
    private int cprnr;
    private boolean medlemskabsstatus;
    private String mail;
    private Betaling betaling;
    private int fødselsdato;

    @Override
    public String toString() {
        return "Medlem{" + "name=" + name + ", cprnr=" + cprnr + ", medlemskabsstatus=" + medlemskabsstatus + ", mail=" + mail + ", betaling=" + betaling + '}';
    }

    public Medlem(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        this.name = name;
        this.cprnr = cprnr;
        this.medlemskabsstatus = medlemskabsstatus;
        this.mail = mail;
        this.fødselsdato = fødselsdato;
        //this.betaling = betaling;
    }

    public void setFødselsdato(int fødselsdato) {
        this.fødselsdato = fødselsdato;
    }
    
//    public void visMedlem(Medlem medlem){
//        jtextfieldName.setText(medlem.getName());
//        jtextfieldCprnr.setText(medlem.getCprnr());
//        jtextfieldMail.setText(medlem.getMail());
//        if (medlemskabsstatus){
//            jradiobuttonAktiv.doClick();
//        }
//        else {
//            jradibuttonPassiv.doClick();
//        }      
//    }
//    
//    public void gemÆndringer(Medlem medlem){
//        String name = jtextfieldName.getText();
//        int cprnr = Integer.parseInt(jtextfieldCprnr.getText());
//        String mail = jtextfieldMail.getText();
//        if (jradiobuttonAktiv.isSelected()){
//            medlemskabsstatus = true;
//        }
//        else{
//            medlemskabsstatus = false;
//        }
//        medlem.setName(name);
//        medlem.setCprnr(cprnr);
//        medlem.setMail(mail);
//        medlem.setMedlemskabsstatus(medlemskabsstatus);
//    }

    public int getFødselsdato() {
        return fødselsdato;
    }
    
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCprnr() {
        return cprnr;
    }

    public void setCprnr(int cprnr) {
        this.cprnr = cprnr;
    }

    public boolean isMedlemskabsstatus() {
        return medlemskabsstatus;
    }

    public void setMedlemskabsstatus(boolean medlemskabsstatus) {
        this.medlemskabsstatus = medlemskabsstatus;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Betaling getBetaling() {
        return betaling;
    }

    public void setBetaling(Betaling betaling) {
        this.betaling = betaling;
    }
    
    
    

}
