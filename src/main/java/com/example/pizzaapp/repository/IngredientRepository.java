package com.example.pizzaapp.repository;

import com.example.pizzaapp.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository
        extends JpaRepository<Ingredient, Long> {
}
