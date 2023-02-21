package com.example.pizzaapp.model;

import com.example.pizzaapp.model.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String doughType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
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

    public Type getType() {
        return type;
    }

    public Ingredient setType(Type type) {
        this.type = type;
        return this;
    }

    public String getDoughType() {
        return doughType;
    }

    public Ingredient setDoughType(String doughType) {
        this.doughType = doughType;
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
