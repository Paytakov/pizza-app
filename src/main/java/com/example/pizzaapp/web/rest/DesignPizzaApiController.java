package com.example.pizzaapp.web.rest;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.repository.PizzaRepository;
import com.example.pizzaapp.web.rest.resource.PizzaModel;
import com.example.pizzaapp.web.rest.resource.PizzaModelAssembler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/design",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignPizzaApiController {

    private PizzaRepository pizzaRepository;

    public DesignPizzaApiController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

//    @GetMapping("/recent")
//    public Iterable<Pizza> recentPizzas() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        return pizzaRepository.findAll(page).getContent();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> pizzaById(@PathVariable("id") Long id) {
        Optional<Pizza> optPizza = pizzaRepository.findById(id);
        if (optPizza.isPresent()) {
            return new ResponseEntity<>(optPizza.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @GetMapping("/recent")
    public CollectionModel<PizzaModel> recentPizzasH() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        Iterable<Pizza> pizzas = pizzaRepository.findAll(page).getContent();

        CollectionModel<PizzaModel> pizzaModels =
                new PizzaModelAssembler().toCollectionModel(pizzas);

        pizzaModels.add(
                linkTo(methodOn(DesignPizzaApiController.class).recentPizzasH())
                        .withRel("recents"));

        return pizzaModels;
    }
}
