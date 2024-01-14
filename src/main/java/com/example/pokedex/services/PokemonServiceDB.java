// Define a service interface named PokemonServiceDB.
package com.example.pokedex.services;

// Import the PokemonDB model class.
import com.example.pokedex.models.PokemonDB;

// Declare the PokemonServiceDB interface with a method to retrieve Pokemon data by ID.
public interface PokemonServiceDB {
    // Method signature for fetching Pokemon data by ID.
    PokemonDB getPokemonById(int pokemonId);
}
