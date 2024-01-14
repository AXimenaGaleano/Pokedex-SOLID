// Import necessary classes/interfaces from 'com.example.pokedex.models' and 'com.example.pokedex.utilities' packages.
package com.example.pokedex.views;
// Define a view class named PokemonView implementing the MultipleFormatGenerator interface.
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.utilities.MultipleFormatGenerator;

public class PokemonView implements MultipleFormatGenerator {

    // Method to generate human-readable text representation of a Pokemon.
    @Override
    public String generateHumanReadableText(Pokemon pokemon) {
        StringBuilder textRepresentation = new StringBuilder();
        textRepresentation.append("=============================\n");
        textRepresentation.append("Pokémon # ").append(String.valueOf(pokemon.getId())).append("\n");
        textRepresentation.append("Nom : ").append(capitalizeFirstLetter(pokemon.getName())).append("\n");
        textRepresentation.append("Taille : ").append(pokemon.getHeight()).append(" m\n");
        textRepresentation.append("Poids : ").append(pokemon.getWeight()).append(" kg\n");
        textRepresentation.append("=============================");
        return textRepresentation.toString();
    }
    // Private method to capitalize the first letter of a string.
    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    // Method to generate HTML representation of a Pokemon.
    @Override
    public String generateHTML(Pokemon pokemon) {
        StringBuilder htmlRepresentation = new StringBuilder();
        htmlRepresentation.append("<h1>").append(pokemon.getName()).append("</h1>\n");
        htmlRepresentation.append("<ul>\n");
        htmlRepresentation.append("<li>Id : ").append(pokemon.getId()).append("</li>\n");
        htmlRepresentation.append("<li>Taille : ").append(pokemon.getHeight()).append("</li>\n");
        htmlRepresentation.append("<li>Poids : ").append(pokemon.getWeight()).append("</li>\n");
        htmlRepresentation.append("</ul>\n");
        return htmlRepresentation.toString();
    }

    // Method to generate CSV representation of a Pokemon.
    @Override
    public String generateCSV(Pokemon pokemon) {
        StringBuilder csvRepresentation = new StringBuilder();
        csvRepresentation.append("Id;Name;Height;Weight;\n");
        csvRepresentation.append(pokemon.getId()).append(";\"");
        csvRepresentation.append(pokemon.getName()).append("\";");
        csvRepresentation.append(pokemon.getHeight()).append(";");
        csvRepresentation.append(pokemon.getWeight()).append(";\n");
        return csvRepresentation.toString();
    }
}