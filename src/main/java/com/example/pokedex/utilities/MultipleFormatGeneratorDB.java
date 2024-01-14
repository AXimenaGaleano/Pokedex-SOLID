// Define an interface named MultipleFormatGeneratorDB for generating multiple output formats for PokemonDB data.
package com.example.pokedex.utilities;
// Import the PokemonDB model class.
import com.example.pokedex.models.PokemonDB;
// Declare the MultipleFormatGeneratorDB interface with methods to generate HTML, CSV, and human-readable text formats.
public interface MultipleFormatGeneratorDB {
    // Method signature for generating HTML format based on PokemonDB data.
    public String generateHTML(PokemonDB pokemon);
    // Method signature for generating CSV format based on PokemonDB data.
    public String generateCSV(PokemonDB pokemon);
    // Method signature for generating CSV format based on PokemonDB data.
    public String generateHumanReadableText(PokemonDB pokemon);
}
