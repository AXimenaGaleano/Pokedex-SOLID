package com.example.pokedex.models;

// Import necessary annotations and classes from the 'javax.persistence' package.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Define an entity class named PokemonDB, representing the structure of the Pokemon data in the database.
@Entity
public class PokemonDB {

    // Annotate the 'id' field as the primary key, automatically generated using an identity strategy.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único en la base de datos

    // Declare fields for the name, description, height, and weight of the Pokemon.
    private String name;
    private String description;
    private double height;
    private double weight;

    // Other attributes and methods specific to the PokemonDB class can be added here.

    // Empty constructor required for JPA (Java Persistence API).
    public PokemonDB() {
    }

    // Parameterized constructor for creating instances of the PokemonDB class with initial data.
    public PokemonDB(Long id, String name, String description, double height, double weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.weight = weight;
    }

    // Getter and setter methods for accessing and modifying the fields of the PokemonDB class.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
