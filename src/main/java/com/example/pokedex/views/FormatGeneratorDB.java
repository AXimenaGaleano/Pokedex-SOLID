package com.example.pokedex.views;

import com.example.pokedex.models.PokemonDB;

public interface FormatGeneratorDB {
    String generateText(PokemonDB pokemon);

    String generateHTML(PokemonDB pokemon);

    String generateCSV(PokemonDB pokemon);
}