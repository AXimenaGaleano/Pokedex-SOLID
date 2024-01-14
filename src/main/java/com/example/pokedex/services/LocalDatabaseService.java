// Import necessary classes/interfaces for working with databases.
import com.example.pokedex.models.PokemonDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Implementation of PokemonServiceDB for retrieving Pokemon data from a local database.
public class LocalDatabaseService implements PokemonServiceDB {

    // URL of the local SQLite database.
    private static final String DATABASE_URL = "jdbc:sqlite:../sujet_TP/resources/pokemondatabase.sqlite";

    // Implementation of the method to get Pokemon data by ID from the local database.
    @Override
    public PokemonDB getPokemonById(int pokemonId) {
        // SQL query to retrieve Pokemon data based on the provided ID.
        String query = "SELECT * FROM pokemons WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the parameter in the prepared statement.
            preparedStatement.setInt(1, pokemonId);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if the result set contains data.
            if (resultSet.next()) {
                // Process the result and convert it into a Pokemon object.
                return parseDatabaseResult(resultSet);
            } else {
                System.out.println("Pokemon not found in the local database.");
            }

        } catch (SQLException e) {
            // Handle SQLException and print an error message.
            System.out.println("Error fetching Pokemon data from the local database: " + e.getMessage());
        }

        return null;
    }

    // Private method to parse the database result and create a PokemonDB object.
    private PokemonDB parseDatabaseResult(ResultSet resultSet) throws SQLException {
        // Extract data from the result set columns.
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        double height = resultSet.getDouble("height");
        double weight = resultSet.getDouble("weight");

        // Create and return a PokemonDB object with the extracted data.
        return new PokemonDB(id, name, description, height, weight);
    }
}
