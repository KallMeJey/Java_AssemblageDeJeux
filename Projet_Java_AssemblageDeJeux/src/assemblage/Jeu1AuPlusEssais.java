package assemblage;

import jeu.Jeu;

/**
 * Assemblage de jeux qui permet de rejouer tant que la limite d'essais n'est pas atteinte.
 *
 * @author Jeneifan
 * @version 2.0
 */
public class Jeu1AuPlusEssais extends Assemblage {

    public Jeu1AuPlusEssais(String nomAssemblage, int nbEssais) {
        super(nomAssemblage, nbEssais);
    }


    @Override
    public void jouer() {

        while (getNbEssais() > 0 && !getEstGagné()) {
            for (Jeu jx : getSousJeux()) {
                try {
                    jx.jouer();
                    ajouterASuiteJoué(jx.getNomJeu(), jx.getEstGagné());
                } catch (Exception e) {
                    jx.setEstGagné(true);
                    ajouterASuiteJoué(jx.getNomJeu(), jx.getEstGagné());
                }
            }
            setNbEssais(getNbEssais() - 1);
        }
    }
}
