package jeugladiateurs;

import personnages.Personnage;
import combat.CompteurDeTour;
import combat.AffichageEcran;

public class JeuGladiateurs {

    public static void main(String[] args) {

        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="expanded" desc="Instanciation des objets">
        CompteurDeTour tour = new CompteurDeTour();
        AffichageEcran affichage = new AffichageEcran();
        personnages.Mirmillon Bob = new personnages.Mirmillon("Bob le malchanceux", 15, 15, 70, 15);
        personnages.R�tiaire Igor = new personnages.R�tiaire("Igor l'empaleur", 25, 5, 100, 30);
        // </editor-fold>

        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="collapsed" desc="Affichage pr�-combat">
        Bob.afficherInfosPersonnage();
        Igor.afficherInfosPersonnage();
        affichage.afficherDebutCombat();

        // </editor-fold>
        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="collapsed" desc="M�canique de combat">
        do {
            tour.afficheTour();
            for (int i = 0; i <= 100; i++) {
                if (Bob.getInitiative() == i) {
                    Bob.frapperPersonnage(Igor);
                    if (Igor.getPointsDeVie() == 0) {
                        break;
                    }
                }
                if (Igor.getInitiative() == i) {
                    Igor.frapperPersonnage(Bob);
                    if (Bob.getPointsDeVie() == 0) {
                        break;
                    }
                }
            }
            affichage.afficherSeparateurInfosPerso();
            Bob.afficherInfosPersonnage();
            Igor.afficherInfosPersonnage();
            Bob.setNewInitiativeRandom();
            Igor.setNewInitiativeRandom();
            tour.augmenteTour();
            affichage.afficherSeparateurDeTour();
        } while (Bob.getPointsDeVie() > 0 && Igor.getPointsDeVie() > 0);

        affichage.afficheVictoire(Igor, Bob);
        // </editor-fold>
    }

}
