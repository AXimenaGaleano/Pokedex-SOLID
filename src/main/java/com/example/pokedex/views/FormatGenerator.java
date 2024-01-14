// Define an interface named FormatGenerator for generating different output formats for Pokemon data.
package com.example.pokedex.views;

// Import the Pokemon model class.
import com.example.pokedex.models.Pokemon;

// Declare the FormatGenerator interface with methods to generate text, HTML, and CSV formats.
public interface FormatGenerator {
    // Method signature for generating text format based on Pokemon data.
    String generateText(Pokemon pokemon);

    // Method signature for generating HTML format based on Pokemon data.
    String generateHTML(Pokemon pokemon);

    // Method signature for generating CSV format based on Pokemon data.
    String generateCSV(Pokemon pokemon);
}
