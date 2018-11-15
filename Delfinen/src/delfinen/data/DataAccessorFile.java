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
    private ArrayList<Motionist> alleMedlemmer = new ArrayList<>();

    //husk at vi også skal bruge en Betaling når vi opretter et medlem, når vi har lavet Betalings klassen
    public void opretMedlem(String name, int cprnr, int fødselsdato, boolean medlemskabsstatus, String mail) {
        ObjectOutputStream out = null;
        try {
            Motionist m = new Motionist(name, cprnr, fødselsdato, medlemskabsstatus, mail);
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            getMedlemmer().add(m);
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

    public ArrayList<Motionist> getMedlemmer() {
        ObjectInputStream in = null;
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            alleMedlemmer = (ArrayList<Motionist>) in.readObject();
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

    public void sletMedlem(Motionist medlem) {
        ObjectOutputStream out = null;
        ArrayList<Motionist> fjernes = new ArrayList();
        try {
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            for (Motionist m : getMedlemmer()) {
                if (m.getCprnr() == medlem.getCprnr()) {
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
        ArrayList<Motionist> medlemmerMedNavn = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Motionist m : getMedlemmer()) {
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

    //nok ikke en metode vi skal bruge, brug søgMedlemPåCprnr2
    public ArrayList søgMedlemPåCprnr(int cprnr) {
        ObjectInputStream in = null;
        ArrayList<Motionist> medlemmerMedCprnr = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Motionist m : getMedlemmer()) {
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
    //nok ikke en metode vi skal bruge, brug søgMedlemPåMail2
    public ArrayList søgMedlemPåMail(String mail) {
        ObjectInputStream in = null;
        ArrayList<Motionist> medlemmerMedCprnr = new ArrayList();
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Motionist m : getMedlemmer()) {
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

    //ikke en metode vi skal bruge, brug redigerMedlem3
    public void redigerMedlem(Motionist medlem, String newName, int newCprnr, int newFødselsdato, boolean NewMedlemskabsstatus, String newMail) {
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


    public Motionist søgMedlemPåCprnr2(int cprnr) {
        ObjectInputStream in = null;
        Motionist result = null;
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Motionist m : getMedlemmer()) {
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

    public Motionist søgMedlemPåMail2(String mail) {
        ObjectInputStream in = null;
        Motionist result = null;
        try {
            File file = new File(FILENAME);
            in = new ObjectInputStream(new FileInputStream(file));
            for (Motionist m : getMedlemmer()) {
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

    //Ikke en metode vi skal bruge, brug redigerMedlem3
    public void redigerMedlem2(Motionist medlem, String newName, int newCprnr, int newFødselsdato, boolean NewMedlemskabsstatus, String newMail) {
        ObjectOutputStream out = null;
        try {
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            sletMedlem(medlem);
            opretMedlem(newName, newCprnr, newFødselsdato, NewMedlemskabsstatus, newMail);
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

    public void redigerMedlem3(Motionist medlem, String newName, int newCprnr, int newFødselsdato, boolean NewMedlemskabsstatus, String newMail) {
        ObjectOutputStream out = null;
        try {
            File file = new File(FILENAME);
            out = new ObjectOutputStream(new FileOutputStream(file));
            for (Motionist m : getMedlemmer()) {
                if (m.getCprnr() == medlem.getCprnr()) {
                    m.setName(newName);
                    m.setCprnr(newCprnr);
                    m.setFødselsdato(newFødselsdato);
                    m.setMedlemskabsstatus(NewMedlemskabsstatus);
                    m.setMail(newMail);
                }
            }
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
}
