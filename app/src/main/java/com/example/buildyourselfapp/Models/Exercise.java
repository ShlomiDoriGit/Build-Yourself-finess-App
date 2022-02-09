package com.example.buildyourselfapp.Models;

import java.util.Timer;

public class Exercise {

    private String name;
    private String description;
    private int sets;
    private int reps;
    private String dayOfWorkout; // A or B
    private boolean genderExercise; // true for man ,false for woman

    public Exercise(){
    }

    public Exercise(String name, String description,
                    int sets, int reps, String dayOfWorkout,
                    boolean genderExercise) {
        this.name = name;
        this.description = description;
        this.sets = sets;
        this.reps = reps;
        this.dayOfWorkout = dayOfWorkout;
        this.genderExercise = genderExercise;
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

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getDayOfWorkout() {
        return dayOfWorkout;
    }

    public void setDayOfWorkout(String dayOfWorkout) {
        this.dayOfWorkout = dayOfWorkout;
    }

    public boolean isGenderExercise() {
        return genderExercise;
    }

    public void setGenderExercise(boolean genderExercise) {
        this.genderExercise = genderExercise;
    }

}
