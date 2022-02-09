package com.example.buildyourselfapp.Models;

public class Meal {

    private String name;
    private String description;
    private Double calories;
    private Double protein;
    private Double carbs;
    private Double fat;
    private int plan; // 1 for cut, 2 for bulk
    private int numberOfMeal;
    private String url;


    public Meal() {
    }

    public Meal(String name, String description, Double calories, Double protein, Double carbs, Double fat, int plan, int numberOfMeal, String url) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.plan = plan;
        this.numberOfMeal = numberOfMeal;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public int getNumberOfMeal() {
        return numberOfMeal;
    }

    public void setNumberOfMeal(int numberOfMeal) {
        this.numberOfMeal = numberOfMeal;
    }

    public int getPlan() {
        return plan;
    }

    public Meal setPlan(int plan) {
        this.plan = plan;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Meal setUrl(String url) {
        this.url = url;
        return this;
    }
}
