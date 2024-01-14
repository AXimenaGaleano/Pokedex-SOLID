// Define a service interface named PokemonService.
package com.example.pokedex.services;

// Import the Pokemon model class.
import com.example.pokedex.models.Pokemon;

// Declare the PokemonService interface with a method to retrieve Pokemon data by ID.
public interface PokemonService {
    // Method signature for fetching Pokemon data by ID.
    Pokemon getPokemonById(int pokemonId);
}

