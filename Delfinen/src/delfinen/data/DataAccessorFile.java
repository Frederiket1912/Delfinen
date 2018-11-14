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

    private String FILENAME = "Medlemmer.txt";
    private ArrayList<Medlem> alleMedlemmer = new ArrayList<>();
    
    //husk at vi også skal bruge en Betaling når vi opretter et medlem, når vi har lavet Betalings klassen
    public void opretMedlem(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        ObjectOutputStream out = null;
        try {
            Medlem m = new Medlem(name, cprnr, fødselsdato, medlemskabsstatus, mail);
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            getMedlemmer().add(m);
            out.writeObject(getMedlemmer());
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

    public ArrayList<Medlem> getMedlemmer() {
        ObjectInputStream in = null;
        try {
            boolean cont = true;
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            alleMedlemmer = (ArrayList<Medlem>) in.readObject();
//            while (cont) {
//                if (m != null) {
//                    alleMedlemmer.add(m);
//                } else {
//                    cont = false;
//                }
//            }
        } catch (FileNotFoundException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
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

    public void sletMedlem(Medlem medlem) {
        ObjectOutputStream out = null;
        ArrayList<Medlem> fjernes = new ArrayList();
        try {
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            for (Medlem m : getMedlemmer()) {
                if (m.getCprnr() == medlem.getCprnr()) {
                    System.out.println("Vi kom her til!");
                    fjernes.add(m);
                    out.flush();
                }
            }
            alleMedlemmer.removeAll(fjernes);
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

    public ArrayList søgMedlemPåNavn(String name) {
        ObjectInputStream in = null;
        ArrayList<Medlem> medlemmerMedNavn = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Medlem m : getMedlemmer()) {
                if (m.getName().contains(name)) {
                    medlemmerMedNavn.add(m);
                }
            }
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
        return medlemmerMedNavn;
    }

    //kunne godt laves om til bare at returne et medlem i stedet for en arraylist,
    //ved ikke om det er letest bare at have alle vores søg metoder til at returne det samme.
    public ArrayList søgMedlemPåCprnr(int cprnr) {
        ObjectInputStream in = null;
        ArrayList<Medlem> medlemmerMedCprnr = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Medlem m : getMedlemmer()) {
                if (m.getCprnr() == cprnr) {
                    medlemmerMedCprnr.add(m);
                }
            }
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
        return medlemmerMedCprnr;
    }

    public ArrayList søgMedlemPåMail(String mail) {
        ObjectInputStream in = null;
        ArrayList<Medlem> medlemmerMedCprnr = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Medlem m : getMedlemmer()) {
                if (m.getMail().equalsIgnoreCase(mail)) {
                    medlemmerMedCprnr.add(m);
                }
            }
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
        return medlemmerMedCprnr;
    }

    //jeg ved ikke om man kan gøre det på en smartere måde så man replacer i stedet for at remove og så adde bagefter
    public void redigerMedlem(Medlem medlem, String newName, int newCprnr, int newFødselsdato, boolean NewMedlemskabsstatus, String newMail) {
        ObjectOutputStream out = null;
        try {
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            getMedlemmer().remove(medlem);
            medlem.setName(newName);
            medlem.setCprnr(newCprnr);
            medlem.setFødselsdato(newFødselsdato);
            medlem.setMedlemskabsstatus(NewMedlemskabsstatus);
            medlem.setMail(newMail);
            getMedlemmer().add(medlem);
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

    //jeg har lavet metoder til at søge medlemmer på cprnr og mail hvor man får
    //et medlem ud i stedet for en arraylist med et medlem
    public Medlem søgMedlemPåCprnr2(int cprnr) {
        ObjectInputStream in = null;
        Medlem result = null;
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Medlem m : getMedlemmer()) {
                if (m.getCprnr() == cprnr) {
                    result = m;
                    return result;
                }

            }
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
        return result;
    }

    public Medlem søgMedlemPåMail2(String mail) {
        ObjectInputStream in = null;
        Medlem result = null;
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Medlem m : getMedlemmer()) {
                if (m.getMail().equalsIgnoreCase(mail)) {
                    result = m;
                    return result;
                }
            }
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
        return result;
    }
}
