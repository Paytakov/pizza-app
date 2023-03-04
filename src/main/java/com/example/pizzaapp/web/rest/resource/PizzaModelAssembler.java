package com.example.pizzaapp.web.rest.resource;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.web.rest.DesignPizzaApiController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class PizzaModelAssembler extends
        RepresentationModelAssemblerSupport<Pizza, PizzaModel> {

    public PizzaModelAssembler() {
        super(DesignPizzaApiController.class, PizzaModel.class);
    }

    @Override
    public PizzaModel instantiateModel(Pizza pizza) {
        return new PizzaModel(pizza);
    }

    @Override
    public PizzaModel toModel(Pizza pizza) {
       return createModelWithId(pizza.getId(), pizza);
    }
}
