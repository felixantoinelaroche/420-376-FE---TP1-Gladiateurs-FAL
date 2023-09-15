package personnages;

import java.util.Random;

public class Rétiaire extends Personnage {

    //**************************************************************************
    //<editor-fold desc="ATTRIBUTS">
    private static boolean enPossessionFilet;

    //</editor-fold>
    //**************************************************************************
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTEURS ET INITIALISATION">
    public Rétiaire(String nom, int attaqueMax, int defense, int pvs, int ini) {
        super(nom, "Rétiaire", attaqueMax, defense, pvs, ini);
        enPossessionFilet = true;
    }

    public Rétiaire() {
        super("", "", 0, 0, 0, 0);
        enPossessionFilet = true;
    }

    //</editor-fold>
    //**************************************************************************
    //<editor-fold desc="MÉTHODES">
    public static boolean attaqueRétiaire(){
        if (enPossessionFilet) {
            enPossessionFilet = false;
            return lancerFilet();
        } else {
            enPossessionFilet = true;
            return false;
        }
    }
    
    private static boolean lancerFilet(){
        Random rand = new Random();
        int reussite = rand.nextInt(10);
        return reussite == 5;
    }
    //</editor-fold>
    //**************************************************************************
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public static boolean isEnPossessionFilet() {
        return enPossessionFilet;
    }

    public void setEstEnPossessionFilet(boolean enPossessionFilet) {
        Rétiaire.enPossessionFilet = enPossessionFilet;
    }
//</editor-fold>

}
