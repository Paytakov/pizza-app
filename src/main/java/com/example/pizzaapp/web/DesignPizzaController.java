package com.example.pizzaapp.web;

import com.example.pizzaapp.model.Ingredient;
import com.example.pizzaapp.model.Order;
import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.model.dto.OrderDto;
import com.example.pizzaapp.model.enums.Type;
import com.example.pizzaapp.repository.PizzaRepository;
import com.example.pizzaapp.service.IngredientService;
import com.example.pizzaapp.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {

    private final IngredientService ingredientService;
    private final PizzaRepository pizzaRepo;

    public DesignPizzaController(IngredientService ingredientService,
                                 PizzaRepository pizzaRepo) {
        this.ingredientService = ingredientService;
        this.pizzaRepo = pizzaRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @GetMapping()
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientService.getAll().forEach(ingredients::add);

        Type[] ingredientsTypes = Type.values();
        for (Type type : ingredientsTypes) {
            model.addAttribute(type.toString().toLowerCase(), ingredients.stream()
                    .filter(i -> i.getType().name().equals(type.name()))
                    .collect(Collectors.toList()));
        }

        model.addAttribute("design", new Pizza());
        return "design-pizza";
    }

    @PostMapping
    public String processDesign(@Valid Pizza design,
                                Errors errors,
                                @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design-pizza";
        }

        Pizza saved = pizzaRepo.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }
}
