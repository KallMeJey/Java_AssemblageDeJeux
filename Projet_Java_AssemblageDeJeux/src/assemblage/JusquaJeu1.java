package assemblage;

import jeu.Jeu;

/**
 * Assemblage de jeu où les jeux sont recommencer tant qu'ils ne sont pas gagnés
 *
 * @author Oscar
 * @version 2.0
 */
public class JusquaJeu1 extends Assemblage {

    public JusquaJeu1(String nomDeLassemblage) {

        //le nombre d'esais n'est pas utilisé dans ce mode d'assemblage
        super(nomDeLassemblage, 1);
    }

    @Override
    public void jouer() {

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
