package com.example.pokedex.controllers;

import com.example.pokedex.models.PokemonDB;
import com.example.pokedex.services.PokemonServiceDB;

public class PokemonDBController {
    private final PokemonServiceDB apiService;

    public PokemonDBController(PokemonServiceDB apiService) {
        this.apiService = apiService;
    }

    public PokemonDB getPokemonById(int pokemonId) {
        return apiService.getPokemonById(pokemonId);
    }
}