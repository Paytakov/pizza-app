package com.example.pizzaapp.web.rest.resource;

import com.example.pizzaapp.model.Ingredient;
import com.example.pizzaapp.model.enums.Type;
import org.springframework.hateoas.RepresentationModel;

public class IngredientModel extends RepresentationModel<IngredientModel> {

    private String name;
    private Type type;

    public IngredientModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
