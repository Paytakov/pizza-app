package com.example.pizzaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Column(nullable = false)
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Column(nullable = false)
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    @Column(nullable = false)
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    @Column(nullable = false)
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    @Column(nullable = false)
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column(nullable = false)
    private String ccCVV;

    private Date placedAt;

    @ManyToMany
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne
    private User user;

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    public void addDesign(Pizza design) {
        this.pizzas.add(design);
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public Order setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
        return this;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public Order setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
        return this;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public Order setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
        return this;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public Order setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
        return this;
    }

    public String getDeliveryZip() {
        return deliveryZip;
    }

    public Order setDeliveryZip(String deliveryZip) {
        this.deliveryZip = deliveryZip;
        return this;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public Order setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
        return this;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public Order setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
        return this;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public Order setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
        return this;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public Order setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public Order setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        return this;
    }
}
