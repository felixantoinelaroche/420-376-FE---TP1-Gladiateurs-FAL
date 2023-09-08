package personnages;

import java.util.Random;

public class Personnage {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Attributs">
    private String nom;
    private String classe;
    private int pointsDeVie;
    private int valeurMaxAttaque;
    private int valeurDefense;
    private int initiative;

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Personnage(String nom, int attaqueMax, int defense, int pvs, int ini) {
        this.nom = nom;
        this.pointsDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }

    public Personnage() {
        nom = "";
        pointsDeVie = 0;
        valeurMaxAttaque = 0;
        valeurDefense = 0;
        initiative = 0;
    }

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    public String getNom() {
        return nom;
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    }

    public String getClasse() {
        return classe;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getValeurMaxAttaque() {
        return valeurMaxAttaque;
    }

    public int getValeurDefense() {
        return valeurDefense;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void setValeurMaxAttaque(int valeurMaxAttaque) {
        this.valeurMaxAttaque = valeurMaxAttaque;
    }

    public void setValeurDefense(int valeurDefense) {
        this.valeurDefense = valeurDefense;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    public void afficherInfosPersonnage() {
        System.out.println("\n" + getNom());
        System.out.println("\tClasse : " + getClasse());
        System.out.println("\tAttaque : " + getValeurMaxAttaque());
        System.out.println("\tDéfense : " + getValeurDefense());
        System.out.println("\tPoints de vie : " + getPointsDeVie());
        System.out.println("\tInitiative : " + getInitiative());
        if (getPointsDeVie() > 0) {
            System.out.println("\tStatut : Vivant");
        } else {
            System.out.println("\tStatut : Mort");
        }
    }

    private int attaqueCalcul() {
        Random rand = new Random();
        int attaque = rand.nextInt((valeurMaxAttaque + 1));
        return attaque;
    }

    public void frapperPersonnage(Personnage personnageCible) {
        int forceFrappe = attaqueCalcul();
        int defense = personnageCible.valeurDefense;
        int dommages = forceFrappe - defense;

        if (dommages < 0) {
            dommages = 0;
        }

        personnageCible.pointsDeVie -= dommages;

        if (personnageCible.pointsDeVie < 0) {
            personnageCible.pointsDeVie = 0;
        }
        
        System.out.println("\n" + nom + " attaque avec une puissance de : " + forceFrappe);
        System.out.println(personnageCible.nom + " a une défense de : " + defense);
        System.out.println("Les dommages sont donc de : " + dommages);
    }

    public void setNewInitiativeRandom() {
        Random rand = new Random();
        initiative = rand.nextInt(101);
    }
    // </editor-fold>
}
