package personnages;

import java.util.Random;

public class R�tiaire extends Personnage {

    //**************************************************************************
    //<editor-fold desc="ATTRIBUTS">
    private static boolean enPossessionFilet;

    //</editor-fold>
    //**************************************************************************
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTEURS ET INITIALISATION">
    public R�tiaire(String nom, int attaqueMax, int defense, int pvs, int ini) {
        super(nom, "R�tiaire", attaqueMax, defense, pvs, ini);
        enPossessionFilet = true;
    }

    public R�tiaire() {
        super("", "", 0, 0, 0, 0);
        enPossessionFilet = true;
    }

    //</editor-fold>
    //**************************************************************************
    //<editor-fold desc="M�THODES">
    public static boolean attaqueR�tiaire(){
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
        R�tiaire.enPossessionFilet = enPossessionFilet;
    }
//</editor-fold>

}
