package com.example.buildyourselfapp.Models;

public class Meal {

    private String name;
    private String description;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private int plan; // 1 for cut, 2 for bulk
    private int numberOfMeal;
    private String url;
    private boolean gender ; // true for man for for woman


    public Meal() {
    }

    public Meal(String name, String description, int calories, int protein, int carbs,
                int fat, int plan, int numberOfMeal, String url , boolean gender) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.plan = plan;
        this.numberOfMeal = numberOfMeal;
        this.url = url;
        this.gender = gender ;
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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
