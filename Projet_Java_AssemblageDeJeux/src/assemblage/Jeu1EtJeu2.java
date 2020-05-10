package assemblage;

import jeu.Jeu;

/**
 * Assemblage de Jeu où tous les jeux qui le compose doivent être gagné.
 *
 * @author Oscar
 * @version 1.0
 */
public class Jeu1EtJeu2 extends Assemblage {

    public Jeu1EtJeu2(String nomAssemblage, int nbEssais) {
        super(nomAssemblage, nbEssais);
    }


    @Override
    public void jouer() {

        for (Jeu jx : getSousJeux()) {

            try {
                jx.jouer();

                if (!jx.getEstGagné()) {
                    this.setEstGagné(false);
                    ajouterASuiteJoué(jx.getNomJeu(), jx.getEstGagné());
                    break;
                }
            } catch (Exception e) {
                jx.setEstGagné(true);
                ajouterASuiteJoué(jx.getNomJeu(), jx.getEstGagné());
            }

        }
    }

}
