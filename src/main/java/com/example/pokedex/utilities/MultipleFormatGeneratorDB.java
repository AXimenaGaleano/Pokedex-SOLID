package com.example.pokedex.utilities;

import com.example.pokedex.models.PokemonDB;

public interface MultipleFormatGeneratorDB {
    public String generateHTML(PokemonDB pokemon);
    public String generateCSV(PokemonDB pokemon);
    public String generateHumanReadableText(PokemonDB pokemon);
}
