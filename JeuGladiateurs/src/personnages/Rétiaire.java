package personnages;

public class Rétiaire extends Personnage {

    //**************************************************************************
    //<editor-fold desc="ATTRIBUTS">
    private boolean enPossessionFilet;

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
    
    //</editor-fold>
    //**************************************************************************
    //<editor-fold defaultstate="collapsed" desc="GETTERS ET SETTERS">
    public boolean isEnPossessionFilet() {
        return enPossessionFilet;
    }

    public void setEstEnPossessionFilet(boolean enPossessionFilet) {
        this.enPossessionFilet = enPossessionFilet;
    }
//</editor-fold>

}
