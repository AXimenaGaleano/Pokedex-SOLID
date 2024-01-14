// Import necessary classes from the Java SQL package.
import java.sql.*;

// Define a class named SQLLiteExample to demonstrate basic SQLite database operations.
public class SQLLiteExample {

    // Method to run the SQLite example.
    public static void run() {
        // Initialize a Connection object for database connection.
        Connection conn = null;

        try {
            // Database parameters: specify the URL for the SQLite database.
            String url = "jdbc:sqlite:../sujet_TP/ressources/pokemondatabase.sqlite";

            // Create a connection to the database.
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            // Prepare a SQL statement with a parameterized query to retrieve Pokemon data.
            PreparedStatement stmt = conn.prepareStatement("SELECT name, description FROM pokemons WHERE id = ?");
            stmt.setInt(1, 3); // Set the value "3" for the parameter at position 1.

            // Execute the query and retrieve the result set.
            ResultSet rs = stmt.executeQuery();

            // Move the cursor to the next row in the result set.
            rs.next();

            // Display Pokemon name and description from the result set.
            System.out.println("Pokémon name: " + rs.getString("name"));
            System.out.println("Pokémon description: " + rs.getString("description"));

        } catch (SQLException e) {
            // Handle SQL exceptions by printing the error message.
            System.out.println(e.getMessage());
        } finally {
            try {
                // Close the database connection in the finally block to ensure it is closed regardless of exceptions.
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection to SQLite closed.");
                }
            } catch (SQLException ex) {
                // Handle any exceptions that may occur while closing the connection.
                System.out.println(ex.getMessage());
            }
        }
    }
}
