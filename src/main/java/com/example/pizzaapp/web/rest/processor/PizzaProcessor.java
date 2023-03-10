package com.example.pizzaapp.web.rest.processor;

import com.example.pizzaapp.model.Pizza;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

public class PizzaProcessor implements RepresentationModelProcessor<PagedModel<EntityModel<Pizza>>> {


    @Override
    public PagedModel<EntityModel<Pizza>> process(PagedModel<EntityModel<Pizza>> model) {
        model.add(
                Link.of("http://localhost:8080/api/pizzas/recent")
                        .withRel(LinkRelation.of("pizzas")));

        return model;
    }
}
