package com.example.pizzaapp.service;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.model.dto.PizzaDto;
import com.example.pizzaapp.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private ModelMapper mapper;

    public PizzaService(PizzaRepository pizzaRepository,
                        ModelMapper mapper) {
        this.pizzaRepository = pizzaRepository;
        this.mapper = mapper;
    }

    public Pizza createPizza(PizzaDto dto) {
        return mapper.map(dto, Pizza.class);
    }
}
