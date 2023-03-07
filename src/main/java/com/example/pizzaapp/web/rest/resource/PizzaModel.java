package com.example.pizzaapp.web.rest.resource;

import com.example.pizzaapp.model.Pizza;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Relation(value = "pizza", collectionRelation = "pizzas")
public class PizzaModel extends RepresentationModel<PizzaModel> {

    private static final IngredientModelAssembler ingredientAssembler =
            new IngredientModelAssembler();

    private final String name;
    private final Date createdAt;
    private final CollectionModel<IngredientModel> ingredients;

    public PizzaModel(Pizza pizza) {
        this.name = pizza.getName();
        this.createdAt = pizza.getCreatedAt();
        this.ingredients =
                ingredientAssembler.toCollectionModel(pizza.getIngredients());
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public CollectionModel<IngredientModel> getIngredients() {
        return ingredients;
    }
}
