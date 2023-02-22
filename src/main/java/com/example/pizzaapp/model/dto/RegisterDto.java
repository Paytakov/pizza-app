package com.example.pizzaapp.model.dto;

public class RegisterDto {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public String getUsername() {
        return username;
    }

    public RegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public RegisterDto setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public RegisterDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public RegisterDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public RegisterDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public RegisterDto setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RegisterDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
