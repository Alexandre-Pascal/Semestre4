package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;

import static com.montaury.pokebagarre.metier.Bagarre.determinerVainqueur;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void meilleureAttaqueGagne() {
        Pokemon lui = new Pokemon("LUILA", "rien.png", new Stats(2,4));
        Pokemon lautre = new Pokemon("lautrela", "rien.png", new Stats(4,4));
        System.out.println(lui.estVainqueurContre(lautre));
    }
    @Test
    void meilleureDefenseGagne() {
        Pokemon lui = new Pokemon("LUILA", "rien.png", new Stats(4,6));
        Pokemon lautre = new Pokemon("lautrela", "rien.png", new Stats(4,4));

        if (lui.getStats().getAttaque() == lautre.getStats().getAttaque()) {
            System.out.println("Les pokemons " + lui.getNom() + " et " + lautre.getNom() + " ont le meme nombre de points d'attaque (" + lui.getStats().getAttaque() + " points)");
        }
        if (determinerVainqueur(lui,lautre) == lui){
            System.out.println("le test est valide car le pokemon " + lui.getNom() + " avec " + lui.getStats().getDefense() + " points de defense gagne " + lautre.getNom() + " qui a " + lautre.getStats().getDefense() + " points de defense" );
        }
    }

    @Test
    void memeStats(){
        Pokemon lui = new Pokemon("LUILA", "rien.png", new Stats(2,4));
        Pokemon lautre = new Pokemon("lautrela", "rien.png", new Stats(4,4));

        if (determinerVainqueur(lui,lautre) == lui){
            System.out.println("le test est validé car le premier rentré gagne");
        }



    }
}