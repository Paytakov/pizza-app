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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zip;

    @Column(nullable = false)
    private String ccNumber;

    @Column(nullable = false)
    private String ccExpiration;

    @Column(nullable = false)
    private String ccCVV;

    private Date placedAt;

    @ManyToMany
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne
    private User user;

    public void addDesign(Pizza design) {
        this.pizzas.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Order setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Order setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Order setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Order setZip(String zip) {
        this.zip = zip;
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
