package com.example.pizzaapp.model.dto;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Zip code is required")
    private String zip;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private Date placedAt;

    private List<Pizza> pizzas = new ArrayList<>();
    private User user;

    public void addDesign(Pizza design) {
        this.pizzas.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    public String getName() {
        return name;
    }

    public OrderDto setName(String name) {
        this.name = name;
        return this;
    }

    public User getUser() {
        return user;
    }

    public OrderDto setUser(User user) {
        this.user = user;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public OrderDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public OrderDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public OrderDto setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public OrderDto setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
        return this;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public OrderDto setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
        return this;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public OrderDto setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
        return this;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public OrderDto setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
        return this;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public OrderDto setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        return this;
    }
}
