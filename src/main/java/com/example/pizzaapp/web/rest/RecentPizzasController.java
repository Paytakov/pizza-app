package com.example.pizzaapp.web.rest;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.repository.PizzaRepository;
import com.example.pizzaapp.web.rest.resource.PizzaModel;
import com.example.pizzaapp.web.rest.resource.PizzaModelAssembler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class RecentPizzasController {

    private PizzaRepository pizzaRepository;

    public RecentPizzasController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping(value = "/pizzas/recent", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<PizzaModel>> recentPizzas() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        Iterable<Pizza> pizzas = pizzaRepository.findAll(page).getContent();

        CollectionModel<PizzaModel> pizzaModels =
                new PizzaModelAssembler().toCollectionModel(pizzas);

        pizzaModels.add(
                linkTo(methodOn(RecentPizzasController.class).recentPizzas())
                        .withRel("recents"));

        return new ResponseEntity<>(pizzaModels, HttpStatus.OK);
    }
}
