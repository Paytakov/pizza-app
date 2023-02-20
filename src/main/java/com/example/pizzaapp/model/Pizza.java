package com.example.pizzaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public Pizza setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pizza setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Pizza setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Pizza setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
