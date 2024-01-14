// Import the necessary classes/interfaces from the 'com.example.pokedex.models' package.
import com.example.pokedex.models.PokemonDB;

// Define a utility class named ConsoleOutputUtilityDB for generating different output formats for PokemonDB data.
public class ConsoleOutputUtilityDB {
    // Fields to store the desired output format and a generator for multiple formats specific to PokemonDB.
    private OutputFormat outputFormat;
    private MultipleFormatGeneratorDB formatsGenerator;

    // Constructor for ConsoleOutputUtilityDB, taking an output format and a format generator as parameters.
    public ConsoleOutputUtilityDB(OutputFormat outputFormat, MultipleFormatGeneratorDB formatsGenerator) {
        this.outputFormat = outputFormat;
        this.formatsGenerator = formatsGenerator;
    }

    // Method to generate output for a given PokemonDB based on the specified output format.
    public String generateOutputDB(PokemonDB pokemon) {
        // Use a conditional statement to determine the output format and generate the corresponding output.
        if (this.outputFormat == OutputFormat.TEXT) {
            return formatsGenerator.generateHumanReadableText(pokemon);
        } else if (this.outputFormat == OutputFormat.HTML) {
            return formatsGenerator.generateHTML(pokemon);
        } else if (this.outputFormat == OutputFormat.CSV) {
            return formatsGenerator.generateCSV(pokemon);
        } else {
            // Handle the case where an invalid output format is specified.
            return "Invalid output format";
        }
    }
}
