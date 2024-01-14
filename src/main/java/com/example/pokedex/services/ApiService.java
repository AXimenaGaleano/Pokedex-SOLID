package com.example.pokedex.services;
// Import necessary classes/interfaces for HTTP operations, JSON handling, and the Pokemon model.
import com.example.pokedex.models.Pokemon;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Implementation of the PokemonService interface to fetch Pokemon data from an external API.
public class ApiService implements PokemonService {
    // Base URL of the API
    private static final String API_BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    // Implementation of the method to get Pokemon data by ID from the API.
    @Override
    public Pokemon getPokemonById(int pokemonId) {
        // Specific logic to retrieve data from the API based on the provided Pokemon ID.
        String apiUrl = API_BASE_URL + pokemonId;

        try {
            // Make an API request and obtain the JSON response.
            String apiResponse = makeApiRequest(apiUrl);
            // Deserialize the JSON response into a Pokemon object using Gson.
            Gson gson = new Gson();
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);

            return pokemon;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); // Handle exceptions appropriately in your application
            return null;
        }
    }

    // Private method to make an HTTP request to the API and return the response body as a string.
    private String makeApiRequest(String apiUrl) throws IOException, InterruptedException {
        // Perform the HTTP request using the HttpClient.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check if the request was successful (status code 200).
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new IOException("HTTP request error: " + response.statusCode());
        }
    }
}
