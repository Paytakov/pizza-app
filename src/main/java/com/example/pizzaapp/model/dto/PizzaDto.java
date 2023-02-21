package com.example.pizzaapp.model.dto;

import com.example.pizzaapp.model.Ingredient;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class PizzaDto {

    private Long id;

    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public PizzaDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PizzaDto setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public PizzaDto setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public PizzaDto setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
