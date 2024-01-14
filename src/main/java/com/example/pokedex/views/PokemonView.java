package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.utilities.MultipleFormatGenerator;

public class PokemonView implements MultipleFormatGenerator {



    @Override
    public String generateHumanReadableText(Pokemon pokemon) {
        StringBuilder textRepresentation = new StringBuilder();
        textRepresentation.append("Pokémon # ").append(pokemon.getId()).append("\n");
        textRepresentation.append("Nom: ").append(pokemon.getName()).append("\n");
        textRepresentation.append("Taille: ").append(pokemon.getHeight()).append(" m\n");
        textRepresentation.append("Poids: ").append(pokemon.getWeight()).append(" kg\n");
        return textRepresentation.toString();
    }

    @Override
    public String generateHTML(Pokemon pokemon) {
        StringBuilder htmlRepresentation = new StringBuilder();
        htmlRepresentation.append("<h1>").append(pokemon.getName()).append("</h1>\n");
        htmlRepresentation.append("<p><b>Taille:</b> ").append(pokemon.getHeight()).append(" m</p>\n");
        htmlRepresentation.append("<p><b>Poids:</b> ").append(pokemon.getWeight()).append(" kg</p>\n");
        return htmlRepresentation.toString();
    }

    @Override
    public String generateCSV(Pokemon pokemon) {
        StringBuilder csvRepresentation = new StringBuilder();
        csvRepresentation.append("Nom, Taille, Poids\n");
        csvRepresentation.append(pokemon.getName()).append(", ");
        csvRepresentation.append(pokemon.getHeight()).append(", ");
        csvRepresentation.append(pokemon.getWeight()).append("\n");
        return csvRepresentation.toString();
    }
}