
package com.example.pokedex.controllers;

// Import necessary classes/interfaces from the 'com.example.pokedex.models' and 'com.example.pokedex.services' packages.
import com.example.pokedex.models.PokemonDB;
import com.example.pokedex.services.PokemonServiceDB;

// Define a controller class named PokemonDBController.
public class PokemonDBController {
    // Declare a private final field 'apiService' of type PokemonServiceDB to handle Pokemon-related services.
    private final PokemonServiceDB apiService;

    // Constructor for PokemonDBController that takes a PokemonServiceDB instance as a parameter and initializes the 'apiService' field.
    public PokemonDBController(PokemonServiceDB apiService) {
        this.apiService = apiService;
    }

    // A method 'getPokemonById' that takes an 'int' parameter 'pokemonId' and returns a PokemonDB object.
    // This method delegates the task of retrieving a Pokemon by ID to the 'apiService'.
    public PokemonDB getPokemonById(int pokemonId) {
        return apiService.getPokemonById(pokemonId);
    }
}