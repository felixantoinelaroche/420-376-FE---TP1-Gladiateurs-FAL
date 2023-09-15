package personnages;

public class R�tiaire extends Personnage {

    //**************************************************************************
    //<editor-fold desc="ATTRIBUTS">
    private boolean enPossessionFilet;

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
