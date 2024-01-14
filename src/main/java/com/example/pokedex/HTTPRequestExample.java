// Import necessary classes from external libraries.
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Define a class named HTTPRequestExample to demonstrate making an HTTP request and processing the JSON response.
public class HTTPRequestExample {

    // Main method to run the HTTP request example.
    public static void run() {
        // Initialize an empty string to store the JSON response.
        String jsonResponse = "";

        try {
            // Create an instance of CloseableHttpClient using HttpClientBuilder.
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            // Create an HTTP GET request to the specified API endpoint.
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/1");
            request.addHeader("content-type", "application/json");

            // Execute the HTTP request and obtain the response.
            HttpResponse result = httpClient.execute(request);

            // Extract the JSON response from the HTTP entity.
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            // Use JSONParser to parse the JSON response.
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);

            // Check if the parsed result is a JSON object.
            if (resultObject instanceof JSONObject) {
                // If it is a JSON object, cast it and extract information.
                JSONObject obj = (JSONObject) resultObject;
                System.out.println("Pokémon name: " + obj.get("name"));
                System.out.println("Pokémon description: weight (" +
                        obj.get("weight") +
                        "), height (" +
                        obj.get("height") +
                        ")"
                );
            } else {
                // If the result is not a JSON object, print an error message.
                System.err.println("Error, we expected a JSON Object from the API");
            }

        } catch (IOException e) {
            // Handle IOException, typically thrown for network-related issues.
            e.printStackTrace();
        } catch (ParseException e) {
            // Handle ParseException when the JSON response cannot be parsed.
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is:");
            System.err.println(jsonResponse);
            e.printStackTrace();

