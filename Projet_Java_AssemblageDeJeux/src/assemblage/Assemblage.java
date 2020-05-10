package assemblage;

import jeu.Jeu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Permet de normaliser le format d'un assemblage de jeux. Tous les différents types d'assemblage devront
 * hériter de cette classe.
 *
 * @author Oscar
 * @version 4.0
 */

public class Assemblage extends Jeu {

    private ArrayList<Jeu> sousJeux;
    private HashMap<String, Boolean> suiteJeuJoués;
    private int nbEssais;
    private boolean estGagné;


    public Assemblage(String nomDeLassemblage, int nbEssais) {
        super(nomDeLassemblage);

        this.estGagné = false;
        this.nbEssais = nbEssais;
        this.sousJeux = new ArrayList<>();
        this.suiteJeuJoués = new HashMap<>();
    }


    public void ajouterASuiteJoué(String nom, Boolean jeuGagné) {
        this.suiteJeuJoués.put(nom, jeuGagné);

    }


    public void afficherSuiteJoué() {

        System.out.println("Suite de jeux joués:");

        for (Map.Entry<String, Boolean> s : suiteJeuJoués.entrySet()) {

            if (s.getValue() == true) {
                System.out.println("Jeu: " + s.getKey() + "    Etat: gagné");
            } else {
                System.out.println("Jeu: " + s.getKey() + "    Etat: perdu");
            }
        }
    }

    @Override
    public String getNomJeu() {
        String nomAssemblage = "";

        for (Jeu j : getSousJeux()) {
            nomAssemblage += "->" + j.getNomJeu();
        }

        return nomAssemblage;
    }

    public void setNbEssais(int nbEssais) {
        this.nbEssais = nbEssais;
    }

    public ArrayList<Jeu> getSousJeux() {
        return this.sousJeux;
    }


    public void ajouterSousJeu(Jeu... jx) {
        ArrayList<Jeu> jeux = new ArrayList<>();

        for (Jeu j : jx) {
            jeux.add(j);
        }

        this.sousJeux = jeux;
    }


    public int getNbEssais() {
        return nbEssais;
    }

    public boolean getEstGagné() {
        int cptGagné = 0;

        for (Jeu j : sousJeux) {
            if (j.getEstGagné()) {
                cptGagné++;
            }
        }
        return cptGagné == sousJeux.size();
    }

}
