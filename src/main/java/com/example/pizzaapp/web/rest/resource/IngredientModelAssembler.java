package com.example.pizzaapp.web.rest.resource;

import com.example.pizzaapp.model.Ingredient;
import com.example.pizzaapp.web.rest.IngredientController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientModelAssembler extends
        RepresentationModelAssemblerSupport<Ingredient, IngredientModel> {


    public IngredientModelAssembler() {
        super(IngredientController.class, IngredientModel.class);
    }

    @Override
    public IngredientModel instantiateModel(Ingredient ingredient) {
        return new IngredientModel(ingredient);
    }

    @Override
    public IngredientModel toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }
}
