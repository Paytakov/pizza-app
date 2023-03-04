package com.example.pizzaapp.web.rest.resource;

import com.example.pizzaapp.model.Ingredient;
import com.example.pizzaapp.model.Pizza;
import org.springframework.hateoas.RepresentationModel;
import java.util.Date;
import java.util.List;

public class PizzaModel extends RepresentationModel<PizzaModel> {

    private final String name;
    private final Date createdAt;
    private final List<Ingredient> ingredients;

    public PizzaModel(Pizza pizza) {
        this.name = pizza.getName();
        this.createdAt = pizza.getCreatedAt();
        this.ingredients = pizza.getIngredients();
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
