package com.example.pokedex.utilities;

import com.example.pokedex.models.PokemonDB;

public class ConsoleOutputUtilityDB {
    private OutputFormat outputFormat;
    private MultipleFormatGeneratorDB formatsGenerator;

    public ConsoleOutputUtilityDB(OutputFormat outputFormat, MultipleFormatGeneratorDB formatsGenerator) {
        this.outputFormat = outputFormat;
        this.formatsGenerator = formatsGenerator;
    }

    public String generateOutput(PokemonDB pokemon) {
        if (this.outputFormat == OutputFormat.TEXT) {
            return formatsGenerator.generateHumanReadableText(pokemon);
        } else if (this.outputFormat == OutputFormat.HTML) {
            return formatsGenerator.generateHTML(pokemon);
        } else if (this.outputFormat == OutputFormat.CSV) {
            return formatsGenerator.generateCSV(pokemon);
        } else {
            return "Invalid output format";
        }
    }
}
