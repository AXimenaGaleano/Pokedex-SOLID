// Import necessary classes/interfaces from 'com.example.pokedex.models' and 'com.example.pokedex.utilities' packages.
import com.example.pokedex.models.PokemonDB;
import com.example.pokedex.utilities.MultipleFormatGeneratorDB;

// Define a view class named PokemonViewDB implementing the MultipleFormatGeneratorDB interface.
public class PokemonViewDB implements MultipleFormatGeneratorDB {

    // Method to generate human-readable text representation of a PokemonDB.
    @Override
    public String generateHumanReadableText(PokemonDB pokemon) {
        StringBuilder textRepresentation = new StringBuilder();
        textRepresentation.append("=============================\n");
        textRepresentation.append("Pokémon # ").append(pokemon.getId()).append("\n");
        textRepresentation.append("Name: ").append(capitalizeFirstLetter(pokemon.getName())).append("\n");
        textRepresentation.append("Description: ").append(pokemon.getDescription()).append("\n");
        textRepresentation.append("Height: ").append(pokemon.getHeight()).append(" m\n");
        textRepresentation.append("Weight: ").append(pokemon.getWeight()).append(" kg\n");
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

    // Method to generate HTML representation of a PokemonDB.
    @Override
    public String generateHTML(PokemonDB pokemon) {
        StringBuilder htmlRepresentation = new StringBuilder();
        htmlRepresentation.append("<h1>").append(pokemon.getName()).append("</h1>\n");
        htmlRepresentation.append("<ul>\n");
        htmlRepresentation.append("<li>Id : ").append(pokemon.getId()).append("</li>\n");
        htmlRepresentation.append("<li>Height: ").append(pokemon.getHeight()).append(" m</li>\n");
        htmlRepresentation.append("<li>Weight: ").append(pokemon.getWeight()).append(" kg</li>\n");
        htmlRepresentation.append("<li>Description: ").append(pokemon.getDescription()).append("</li>\n");
        htmlRepresentation.append("</ul>\n");
        return htmlRepresentation.toString();
    }

    // Method to generate CSV representation of a PokemonDB.
    @Override
    public String generateCSV(PokemonDB pokemon) {
        StringBuilder csvRepresentation = new StringBuilder();
        csvRepresentation.append("Id;Name;Description;Height;Weight\n");
        csvRepresentation.append(pokemon.getId()).append(";\"");
        csvRepresentation.append(pokemon.getName()).append("\";");
        csvRepresentation.append(pokemon.getDescription()).append(";");
        csvRepresentation.append(pokemon.getHeight()).append(";");
        csvRepresentation.append(pokemon.getWeight()).append(";\n");
        return csvRepresentation.toString();
    }
}
