package com.example.pizzaapp.model;

import com.example.pizzaapp.model.enums.DoughType;
import com.example.pizzaapp.model.enums.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private DoughType doughType;

    private Type type;

    public Long getId() {
        return id;
    }

    public Ingredient setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public DoughType getDoughType() {
        return doughType;
    }

    public Ingredient setDoughType(DoughType doughType) {
        this.doughType = doughType;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Ingredient setType(Type type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doughType=" + doughType +
                ", type=" + type +
                '}';
    }
}
