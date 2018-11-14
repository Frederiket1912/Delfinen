/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

/**
 *
 * @author Talha Noory
 */
public class Kontingent {
    private int passivPris = 500;
    private int juniorPris = 1000;
    private int voksenPris = 1600;
    private int seniorPris = 1200;


    public Kontingent(int passivPris, int juniorPris, int voksenPris, int seniorPris) {
        this.passivPris = passivPris;
        this.juniorPris = juniorPris;
        this.voksenPris = voksenPris;
        this.seniorPris = seniorPris;
    }
    
    public int getPassivPris() {
        return passivPris;
    }

    public void setPassivPris(int passivPris) {
        this.passivPris = passivPris;
    }

    public int getJuniorPris() {
        return juniorPris;
    }

    public void setJuniorPris(int juniorPris) {
        this.juniorPris = juniorPris;
    }

    public int getVoksenPris() {
        return voksenPris;
    }

    public void setVoksenPris(int voksenPris) {
        this.voksenPris = voksenPris;
    }

    public int getSeniorPris() {
        return seniorPris;
    }

    public void setSeniorPris(int seniorPris) {
        this.seniorPris = seniorPris;
    }

    @Override
    public String toString() {
        return "Kontingent{" + "passivPris " + passivPris + ", juniorPris " + juniorPris + ", voksenPris " + voksenPris + ", seniorPris " + seniorPris + '}';
    }
    
}
