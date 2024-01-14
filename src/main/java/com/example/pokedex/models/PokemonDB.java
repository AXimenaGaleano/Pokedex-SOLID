package com.example.pokedex.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PokemonDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único en la base de datos

    private String name;
    private String description;
    private double height;
    private double weight;

    // Otros atributos y métodos de la clase Pokemon

    // Constructor vacío necesario para JPA
    public PokemonDB() {
    }

    public PokemonDB(String name, String description, double height, double weight) {
        this.name = name;
        this.description = description;
        this.height = height;
        this.weight = weight;
    }

    // Getters y setters

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
