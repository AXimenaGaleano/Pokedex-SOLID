// Import necessary classes and packages.
import com.example.pokedex.controllers.PokemonController;
import com.example.pokedex.controllers.PokemonDBController;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDB;
import com.example.pokedex.services.ApiService;
import com.example.pokedex.services.LocalDatabaseService;
import com.example.pokedex.services.PokemonService;
import com.example.pokedex.services.PokemonServiceDB;
import com.example.pokedex.utilities.ConsoleOutputUtility;
import com.example.pokedex.utilities.ConsoleOutputUtilityDB;
import com.example.pokedex.utilities.OutputFormat;
import com.example.pokedex.views.PokemonView;
import com.example.pokedex.views.PokemonViewDB;
import org.apache.commons.cli.*;

// Define a class named Pokedex to interact with Pokemon data using command line arguments.
public class Pokedex {

    // Enum for specifying data source (WEB_API or LOCAL_DATABASE).
    private enum DataSource { WEB_API, LOCAL_DATABASE }

    // Default data source is WEB_API.
    private static DataSource dataSource = DataSource.WEB_API;

    // Variables for command line arguments.
    private static String databasePath;
    private static OutputFormat outputFormat = OutputFormat.TEXT;
    private static int pokemonId;

    // Main method to run the Pokedex application.
    public static void main(String[] args) throws ParseException {

        // Parse command line arguments.
        try {
            parseCommandLineArguments(args);
        } catch (PokemonCommandLineParsingException e) {
            System.err.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("./Pokedex <PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]", e.getOptions());
            System.exit(0);
        }

        // Use the appropriate service based on the selected data source.
        PokemonService dataService;
        PokemonServiceDB dataServiceDB;

        if (dataSource == DataSource.WEB_API) {
            dataService = new ApiService();
            PokemonController pokemonController = new PokemonController(dataService);

            // Use the PokemonController to get Pokemon data.
            Pokemon pokemon = pokemonController.getPokemonById(pokemonId);

            // Display Pokemon data using ConsoleOutputUtility.
            if (pokemon != null) {
                PokemonView pokemonView = new PokemonView();
                ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(outputFormat, pokemonView);
                String output = consoleOutputUtility.generateOutput(pokemon);
                System.out.println(output);
            } else {
                System.out.println("Failed to retrieve Pokemon information.");
            }
        } else {
            dataServiceDB = new LocalDatabaseService();
            PokemonDBController pokemondbController = new PokemonDBController(dataServiceDB);

            // Use the PokemonDBController instance to get Pokemon data.
            PokemonDB pokemon = pokemondbController.getPokemonById(pokemonId);

            // Display Pokemon data using ConsoleOutputUtilityDB.
            if (pokemon != null) {
                PokemonViewDB pokemonView = new PokemonViewDB();
                ConsoleOutputUtilityDB consoleOutputUtility = new ConsoleOutputUtilityDB(outputFormat, pokemonView);
                String output = consoleOutputUtility.generateOutputDB(pokemon);
                System.out.println(output);
            } else {
                System.out.println("Failed to retrieve Pokemon information.");
            }
        }
    }

    // Method to parse command line arguments.
    public static void parseCommandLineArguments(String[] args) throws PokemonCommandLineParsingException, ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("d", "database", true, "Path to a SQLite database containing pokemons");
        options.addOption("f", "format", true, "Specify the output format, between 'text', 'html' and 'csv'. By default 'text'.");
        options.addOption("s", "source", true, "Specify the data source, either 'web' or 'local'. By default 'web'.");

        // Parse the command line arguments.
        CommandLine line = parser.parse(options, args);

        if (line.hasOption("d")) {
            // If the database option is provided, set the data source to LOCAL_DATABASE and get the database path.
            dataSource = DataSource.LOCAL_DATABASE;
            databasePath = line.getOptionValue("d");
        }

        if (line.hasOption("f")) {
            // If the format option is provided, set the output format accordingly.
            String formatArgValue = line.getOptionValue("f");
            if (formatArgValue.equals("html")) {
                outputFormat = OutputFormat.HTML;
            } else if (formatArgValue.equals("csv")) {
                outputFormat = OutputFormat.CSV;
            } else if (formatArgValue.equals("text")) {
                outputFormat = OutputFormat.TEXT;
            } else {
                throw new PokemonCommandLineParsingException("Invalid value for the option -f/--format", options);
            }
        }

        if (line.hasOption("s")) {
            // If the source option is provided, set the data source accordingly.
            String sourceArgValue = line.getOptionValue("s");
            if (sourceArgValue.equals("local")) {
                dataSource = DataSource.LOCAL_DATABASE;
            } else if (sourceArgValue.equals("web")) {
                dataSource = DataSource.WEB_API;
            } else {
                throw new PokemonCommandLineParsingException("Invalid value for the option -s/--source", options);
            }
        }

        // Get the Pokemon ID from the remaining arguments.
        String[] remainingArgs = line.getArgs();
        if (remainingArgs.length < 1) {
            throw new PokemonCommandLineParsingException("You must provide a Pokemon ID", options);
        }
        try {
            pokemonId = Integer.parseInt(remainingArgs[0]);
        } catch (NumberFormatException e) {
            throw new PokemonCommandLineParsingException("'" + remainingArgs[0] + "' is not a valid Pokemon ID", options);
        }
    }

    // Custom exception class for command line parsing errors.
    static class PokemonCommandLineParsingException extends Exception {

        private Options options;

        // Constructor to set the exception message and options.
        public PokemonCommandLineParsingException(String msg, Options options) {
            super(msg);
            this.options = options;
        }

        // Getter for options.
        public Options getOptions() {
            return options;
        }
    }
}

