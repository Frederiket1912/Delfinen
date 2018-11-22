package delfinen.data;

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

    private String FILENAME = "Medlemmer.txt";
    
    public void skrivTilFil(ArrayList<Medlem> alleMedlemmer){
        ObjectOutputStream out = null;
        try {
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(alleMedlemmer);
            out.flush();
        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                if (DEBUG) {
                    ex.printStackTrace();
                }
            }
        }    
    }
    
    public ArrayList<Medlem> læsFil() throws ClassNotFoundException{
        ObjectInputStream in = null;
        ArrayList<Medlem> alleMedlemmer = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            alleMedlemmer = (ArrayList<Medlem>) in.readObject();
        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                if (DEBUG) {
                    ex.printStackTrace();
                }
            }
        }
            return alleMedlemmer;
    }
}
