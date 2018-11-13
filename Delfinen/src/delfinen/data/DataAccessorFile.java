
package delfinen.data;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Context.DEBUG;


public class DataAccessorFile {
    private String FILENAME = "C:\\Users\\frede\\OneDrive\\Documents\\NetBeansProjects\\Delfinen\\Medlemmer.txt";   
    private ArrayList<Medlem> alleMedlemmer = new ArrayList<>();
    
    public void opretMedlem(){
        ObjectOutputStream out = null;
        try {
//            String name = jtextfieldName.getText();
//            int cprnr = Integer.parseInt(jtextfieldCprnr.getText());
//            String mail = jtextfieldMail.getText();
//        if (jradiobuttonAktiv.isSelected()){
//            medlemskabsstatus = true;
//        }
//        else{
//            medlemskabsstatus = false;
//        }
        Medlem m = new Medlem("Frederik",1912891867,true,"frederiket@gmail.com");
        Medlem m1 = new Medlem("Frederik",1912891867,true,"frederiket@gmail.com");
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(m);
            out.writeObject(m1);
            out.flush();
        } catch (FileNotFoundException ex) {
            if(DEBUG) ex.printStackTrace();
        } catch (IOException ex) {
            if(DEBUG) ex.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                if(DEBUG) ex.printStackTrace();
            }
        }
    }
    
    public void getMedlemmer(){
        ObjectInputStream in = null;
        try {
            boolean cont = true;
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            while(cont){
            Medlem m = (Medlem) in.readObject();
            if (m != null){
                alleMedlemmer.add(m);
            }
            else{
                cont = false;
            }
            System.out.println(alleMedlemmer);
            }
        } catch (FileNotFoundException ex) {
            if(DEBUG) ex.printStackTrace();
        } catch (IOException ex) {
            if(DEBUG) ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            if(DEBUG) ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                if(DEBUG) ex.printStackTrace();
            }
        }
    }
}
