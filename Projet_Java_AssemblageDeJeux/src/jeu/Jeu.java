package jeu;

/**
 * Permet de normaliser le format des jeux qui pourront être joué. Chaque jeu doit hériter de cette classe.
 *
 * @author Jeneifan
 * @version 3.0
 */

public abstract class Jeu {

    private String nom;
    private String[] arguments;
    private boolean estGagné;


    public Jeu(String nom) {
        this.nom = nom;
        this.estGagné = false;
    }

    public Jeu(String nom, String[] args) {
        this.nom = nom;
        this.estGagné = false;
        this.arguments = args;
    }


    public abstract void jouer();


    public String getNomJeu() {
        return this.nom;
    }


    public void setEstGagné(boolean gagné) {
        this.estGagné = gagné;
    }


    public boolean getEstGagné() {
        return this.estGagné;
    }


    public String[] getArguments() {
        return this.arguments;
    }
}
