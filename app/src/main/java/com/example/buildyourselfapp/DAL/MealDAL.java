package com.example.buildyourselfapp.DAL;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.buildyourselfapp.Models.Exercise;
import com.example.buildyourselfapp.Models.Meal;
import com.example.buildyourselfapp.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MealDAL {

    private static MealDAL instance;
    private DatabaseReference mDatabase;
    private ArrayList<Meal> allMeals;

    private MealDAL() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child(Meal.class.getSimpleName());
        this.allMeals = new ArrayList<>();
        this.listenToMeals();
    }

    public static MealDAL getInstance(){
        if(instance==null)
            instance = new MealDAL();
        return instance;
    }

    public void addMealToDatabase(Meal meal){
        int id = this.allMeals.size();
        this.mDatabase.child(String.valueOf(id)).setValue(meal);
    }

    private void listenToMeals(){
        this.mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                allMeals.clear();
                for (DataSnapshot snp: snapshot.getChildren()) {
                    allMeals.add(snp.getValue(Meal.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MealDAL.listenToMeals",error.getMessage());
                Log.e("MealDAL.listenToMeals",error.getDetails());
            }
        });
    }

    public ArrayList<Meal> getMealsForUser(User user){
        ArrayList<Meal> arr = new ArrayList<Meal>();
        arr.addAll(this.allMeals.stream().filter( meal -> meal.getPlan() == user.getPlan()).collect(Collectors.toList()));
        return arr;
    }
}
