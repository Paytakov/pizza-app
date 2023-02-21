package com.example.pizzaapp;

import com.example.pizzaapp.model.Ingredient;
import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.model.enums.Type;
import com.example.pizzaapp.repository.IngredientRepository;
import com.example.pizzaapp.repository.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DevConfig implements CommandLineRunner {

    private IngredientRepository ingredientRepository;
    private PizzaRepository pizzaRepository;

    public DevConfig(IngredientRepository ingredientRepository, PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Ingredient crispyDough = new Ingredient("Thin & Crispy dough", Type.DOUGH);
        Ingredient italianDough = new Ingredient("Thin Italian Style dough", Type.DOUGH);
        Ingredient pepperoniDough = new Ingredient("Hand-tossed dough with pepperoni stuffed", Type.DOUGH);
        Ingredient groundBeef = new Ingredient("Ground Beef", Type.PROTEIN);
        Ingredient tomatoes = new Ingredient("Fresh Tomatoes", Type.VEGGIES);
        Ingredient mushrooms = new Ingredient("Mushrooms", Type.VEGGIES);
        Ingredient peppers = new Ingredient("Peppers", Type.VEGGIES);
        Ingredient cheddar = new Ingredient("Cheddar", Type.CHEESE);
        Ingredient mozzarella = new Ingredient("Mozzarella", Type.CHEESE);
        Ingredient barbecue = new Ingredient("Barbecue", Type.SAUCE);
        Ingredient freshCream = new Ingredient("Fresh Cream", Type.SAUCE);
        Ingredient bacon = new Ingredient("Bacon", Type.MEAT);
        Ingredient pepperoni = new Ingredient("Pepperoni", Type.MEAT);
        Ingredient basil = new Ingredient("Basil", Type.SPICES);
        Ingredient chubritsa = new Ingredient("Chubritsa", Type.SPICES);
        Ingredient oregano = new Ingredient("Oregano", Type.SPICES);

        if (ingredientRepository.count() == 0) {
            ingredientRepository.save(crispyDough);
            ingredientRepository.save(italianDough);
            ingredientRepository.save(pepperoniDough);
            ingredientRepository.save(groundBeef);
            ingredientRepository.save(tomatoes);
            ingredientRepository.save(mushrooms);
            ingredientRepository.save(peppers);
            ingredientRepository.save(cheddar);
            ingredientRepository.save(mozzarella);
            ingredientRepository.save(barbecue);
            ingredientRepository.save(freshCream);
            ingredientRepository.save(bacon);
            ingredientRepository.save(pepperoni);
            ingredientRepository.save(basil);
            ingredientRepository.save(chubritsa);
            ingredientRepository.save(oregano);
        }



//        userRepository.save(new User("habuma", encoder.encode("password"),
//                "Craig Walls", "123 North Street", "Cross Roads", "TX",
//                "76227", "123-123-1234"));

        Pizza pizza1 = new Pizza();
        pizza1.setName("Italian dream");
        pizza1.setIngredients(Arrays.asList(
                italianDough, groundBeef, tomatoes, pepperoni, oregano, basil, cheddar, mozzarella));
        pizzaRepository.save(pizza1);

        Pizza pizza2 = new Pizza();
        pizza2.setName("Diet pizza");
        pizza2.setIngredients(Arrays.asList(
                crispyDough, bacon, cheddar, peppers, freshCream));
        pizzaRepository.save(pizza2);

        Pizza pizza3 = new Pizza();
        pizza3.setName("Veg-Out");
        pizza3.setIngredients(Arrays.asList(
                crispyDough, peppers, tomatoes, mushrooms, chubritsa));
        pizzaRepository.save(pizza3);
    }
}
