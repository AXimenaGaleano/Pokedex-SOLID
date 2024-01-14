package com.example.pokedex.services;

import com.example.pokedex.models.PokemonDB;

public interface PokemonServiceDB {
    PokemonDB getPokemonById(int pokemonId);
}

