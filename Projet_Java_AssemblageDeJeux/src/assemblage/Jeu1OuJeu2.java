package assemblage;

import jeu.Jeu;

/**
 * Ce type d'assemblage permet de créer une suite de jeux pour laquelle il faut gagné un nombre défini de
 * jeux parmis ceux-ci pour considérer l'assemblage gagné.
 *
 * @author oscar
 * @version 2.0
 */

public class Jeu1OuJeu2 extends Assemblage {

    // le nombre de jeu qu'il faut gagné pour l'assemblage sit considérer gagné
    private int nbJeuAGagné;


    public Jeu1OuJeu2(String nomAssemblage, int nbJeuAGagné) {

        //Le nombre d'essais n'est pas pris en compte pour ce mode d'assemblage
        super(nomAssemblage, 1);

        this.nbJeuAGagné = nbJeuAGagné;
    }


    @Override
    public boolean getEstGagné() {
        int cptGagné = 0;

        for (Jeu j : getSousJeux()) {

            if (j.getEstGagné()) {
                cptGagné++;
            }
        }
        return cptGagné >= nbJeuAGagné;
    }

    @Override
    public void jouer() {

        if (nbJeuAGagné > getSousJeux().size()) {
            System.err.println("Le nombre de jeux doit être supérieur au nombre de jeux qu'il faut gagner.");

        } else {

            while (!getEstGagné()) {

                for (Jeu jx : getSousJeux()) {

                    try {
                        jx.jouer();
                        ajouterASuiteJoué(jx.getNomJeu(), jx.getEstGagné());

                    } catch (Exception e) {

                        jx.setEstGagné(true);
                        ajouterASuiteJoué(jx.getNomJeu(), jx.getEstGagné());
                    }
                }
            }
        }


    }
}
