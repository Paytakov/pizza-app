package com.example.pizzaapp.repository;

import com.example.pizzaapp.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository
        extends JpaRepository<Pizza, Long> {
}
