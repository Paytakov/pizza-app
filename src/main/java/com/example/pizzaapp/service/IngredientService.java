package com.example.pizzaapp.service;

import com.example.pizzaapp.model.Ingredient;
import com.example.pizzaapp.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepo;

    public IngredientService(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public List<Ingredient> getAll() {
        return ingredientRepo.findAll()
                .stream()
                .toList();
    }
}
