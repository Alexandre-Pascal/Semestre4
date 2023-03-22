package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.Mixer;
import java.util.Set;

import static com.montaury.pokebagarre.metier.Bagarre.estVide;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class BagarreTest {

    //public static Pokemon determinerVainqueur(Pokemon premierPokemon, Pokemon secondPokemon) {
    //    return premierPokemon.estVainqueurContre(secondPokemon) ? premierPokemon : secondPokemon;
    //}

    Pokemon lui = new Pokemon("LUILA", "rien.png", new Stats(4,6));
    Pokemon lautre = new Pokemon("lautrela", "rien.png", new Stats(4,4));

    @Test
    void verifierPrenomDiff() {
        assertThat(lui.getNom()).isEqualTo("LUILA"); //teste si le nom est bien le bon
        // assertThat(Bagarre.validerNomPokemons(lui.getNom(), lautre.getNom()) == "oui");

        assertThat(estVide(lui.getNom()) == false);


        assertThat(lautre.getNom()).isEqualTo("lautrela");

        ass

        assertThat(lui.getNom()).isNotEqualTo(lautre.getNom());

        Mixer synchronizer;
        //syntaxe var throwable = catchThrowable(() -> synchronizer.synchronize(serverApi, Set.of("projectKey"), progressMonitor));

    }

    @Test
    void testDeterminerVainqueur(){
//        Bagarre.determinerVainqueur()

    }



    @Test
    void demarrer() {
    }

    @Test
    void determinerVainqueur() {
    }
}