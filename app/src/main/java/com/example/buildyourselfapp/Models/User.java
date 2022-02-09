package com.example.buildyourselfapp.Models;

public class User {

    int id;
    private String username;
    private String email;
    private String password;
    private Double height;
    private Double weight;
    private Boolean gender; //True for man, False for women
    private int plan; // 0 none , 1 cut , 2 bulk
    public User() {
    }

    public User(int id, String username, String email, String password, Double height, Double weight, Boolean gender, int plan) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.plan = plan;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public User setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public User setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public User setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public int getPlan() {
        return plan;
    }

    public User setPlan(int plan) {
        this.plan = plan;
        return this;
    }
}
