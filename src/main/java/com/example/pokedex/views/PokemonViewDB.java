package com.example.pokedex.views;

import com.example.pokedex.models.PokemonDB;
import com.example.pokedex.utilities.MultipleFormatGeneratorDB;

public class PokemonViewDB implements MultipleFormatGeneratorDB {


    @Override
    public String generateHumanReadableText(PokemonDB pokemon) {
        StringBuilder textRepresentation = new StringBuilder();
        textRepresentation.append("Name: ").append(pokemon.getName()).append("\n");
        textRepresentation.append("Description: ").append(pokemon.getDescription()).append("\n");
        textRepresentation.append("Taille: ").append(pokemon.getHeight()).append(" m\n");
        textRepresentation.append("Poids: ").append(pokemon.getWeight()).append(" kg\n");
        // Agregar más detalles según sea necesario
        return textRepresentation.toString();
    }

    @Override
    public String generateHTML(PokemonDB pokemon) {
        StringBuilder htmlRepresentation = new StringBuilder();
        htmlRepresentation.append("<h1>").append(pokemon.getName()).append("</h1>\n");
        htmlRepresentation.append("<p><b>Description:</b> ").append(pokemon.getDescription()).append("</p>\n");
        htmlRepresentation.append("<p><b>Taille:</b> ").append(pokemon.getHeight()).append(" m</p>\n");
        htmlRepresentation.append("<p><b>Poids:</b> ").append(pokemon.getWeight()).append(" kg</p>\n");
        return htmlRepresentation.toString();
    }

    @Override
    public String generateCSV(PokemonDB pokemon) {
        StringBuilder csvRepresentation = new StringBuilder();
        csvRepresentation.append("Name, Description, Taille, Poids\n");
        csvRepresentation.append(pokemon.getName()).append(", ");
        csvRepresentation.append(pokemon.getDescription()).append(", ");
        csvRepresentation.append(pokemon.getHeight()).append(", ");
        csvRepresentation.append(pokemon.getWeight()).append("\n");
        return csvRepresentation.toString();
    }
}