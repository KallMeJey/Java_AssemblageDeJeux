import assemblage.Assemblage;
import assemblage.Jeu1OuJeu2;
import jeux.intrus.Intrus;
import jeux.pppg.PlusPetitPlusGrand;

/**
 * Permet de créer des jeux personnalisés (assemblages de jeux) et de les exécuter
 *
 * @author Jeneifan
 * @version 2.0
 */
public class MoteurDeJeu {

    public static void main(String[] args) {


        // Exemple d'assamblage créé avec notre solution
        Assemblage asm1 = new Jeu1OuJeu2("assemblage test", 1);

        asm1.ajouterSousJeu(new Intrus("jeu 1"), new PlusPetitPlusGrand("jeu 2", args));

        asm1.jouer();

        System.out.println("Assemblage gagné: " + asm1.getEstGagné());

        asm1.afficherSuiteJoué();

    }
}
