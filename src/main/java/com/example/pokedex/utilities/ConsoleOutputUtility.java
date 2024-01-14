// Import the necessary classes/interfaces from the 'com.example.pokedex.models' package.
import com.example.pokedex.models.Pokemon;

// Define a utility class named ConsoleOutputUtility for generating different output formats for Pokemon data.
public class ConsoleOutputUtility {
    // Fields to store the desired output format and a generator for multiple formats.
    private OutputFormat outputFormat;
    private MultipleFormatGenerator formatsGenerator;

    // Constructor for ConsoleOutputUtility, taking an output format and a format generator as parameters.
    public ConsoleOutputUtility(OutputFormat outputFormat, MultipleFormatGenerator formatsGenerator) {
        this.outputFormat = outputFormat;
        this.formatsGenerator = formatsGenerator;
    }

    // Method to generate output for a given Pokemon based on the specified output format.
    public String generateOutput(Pokemon pokemon) {
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
