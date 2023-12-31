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
    public Personnage(String nom, String classe, int attaqueMax, int defense, int pvs, int ini) {
        this.nom = nom;
        this.classe = classe;
        this.pointsDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }
    
    public Personnage() {
        nom = "";
        classe = "";
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
    // <editor-fold defaultstate="collapsed" desc="M�canique de jeu">
    public void afficherInfosPersonnage() {
        System.out.println("\n" + getNom());
        System.out.println("\tClasse : " + getClasse());
        System.out.println("\tAttaque : " + getValeurMaxAttaque());
        System.out.println("\tD�fense : " + getValeurDefense());
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
        if ("R�tiaire".equals(classe)) {
            if (R�tiaire.isEnPossessionFilet()) {
                System.out.println("\n" + nom + " lance son filet");
            }
            boolean lancerFilet = R�tiaire.attaqueR�tiaire();
            if (lancerFilet) {
                personnageCible.pointsDeVie = 0;
                System.out.println("Son filet attrape " + personnageCible.nom + " et il l'empale avec sa lance");
                return;
            } else {
                if (!R�tiaire.isEnPossessionFilet()) {
                    System.out.println("Le filet n'atteint pas sa cible");
                    return;
                } else {
                    System.out.println("\n" + nom + " ramasse son filet et en profite pour attaquer");
                }
            }
        }
        
        for (int i = 0; i < ("Mirmillon".equals(classe)?2:1); i++) {
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
            System.out.println(personnageCible.nom + " a une d�fense de : " + defense);
            System.out.println("Les dommages sont donc de : " + dommages);
            if ("Mirmillon".equals(classe) && i==0) {
                if (personnageCible.getPointsDeVie() == 0) {
                    System.out.println("\n" + nom + " d�capite " + personnageCible.getNom());
                    return;
                } else {
                    System.out.println("\n" + nom + " attaque de nouveau");
                }
            }
        }
        
    }
    
    public void setNewInitiativeRandom() {
        Random rand = new Random();
        initiative = rand.nextInt("Mirmillon".equals(classe) ? 31 : 101);
    }
    // </editor-fold>
}
