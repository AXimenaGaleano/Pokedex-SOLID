package com.example.pokedex.controllers;

import com.google.gson.Gson;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.PokemonService;

// This class serves as a controller for handling Pokemon-related operations.
public class PokemonController {

    // The PokemonService instance responsible for fetching Pokemon data.
    private final PokemonService apiService;

    // Constructor for PokemonController, initializing it with a PokemonService.
    public PokemonController(PokemonService apiService) {
        this.apiService = apiService;
    }

    // Retrieves Pokemon information based on the provided Pokemon ID.
    public Pokemon getPokemonById(int pokemonId) {
        return apiService.getPokemonById(pokemonId);
    }
}
