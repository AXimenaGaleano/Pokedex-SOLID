// Define an interface named FormatGeneratorDB for generating different output formats for PokemonDB data.
package com.example.pokedex.views;

// Import the PokemonDB model class.
import com.example.pokedex.models.PokemonDB;

// Declare the FormatGeneratorDB interface with methods to generate text, HTML, and CSV formats.
public interface FormatGeneratorDB {
    // Method signature for generating text format based on PokemonDB data.
    String generateText(PokemonDB pokemon);

    // Method signature for generating HTML format based on PokemonDB data.
    String generateHTML(PokemonDB pokemon);

    // Method signature for generating CSV format based on PokemonDB data.
    String generateCSV(PokemonDB pokemon);
}
