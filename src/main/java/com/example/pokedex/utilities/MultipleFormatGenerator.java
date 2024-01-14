// Define an interface named MultipleFormatGenerator for generating multiple output formats for Pokemon data.
package com.example.pokedex.utilities;
// Import the Pokemon model class.
import com.example.pokedex.models.Pokemon;

// Declare the MultipleFormatGenerator interface with methods to generate HTML, CSV, and human-readable text formats.
public interface MultipleFormatGenerator {
    // Method signature for generating HTML format based on Pokemon data.
    public String generateHTML(Pokemon pokemon);
    // Method signature for generating CSV format based on Pokemon data.
    public String generateCSV(Pokemon pokemon);
    // Method signature for generating human-readable text format based on Pokemon data.
    public String generateHumanReadableText(Pokemon pokemon);
}
