package com.example.buildyourselfapp.DAL;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.buildyourselfapp.Models.Exercise;
import com.example.buildyourselfapp.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ExerciseDAL {

    private static ExerciseDAL instance;
    private DatabaseReference mDatabase;
    private ArrayList<Exercise> allExercises;

    private ExerciseDAL() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child(Exercise.class.getSimpleName());
        this.allExercises = new ArrayList<>();
        this.listenToExercises();
    }

    public static ExerciseDAL getInstance(){
        if(instance==null)
            instance = new ExerciseDAL();
        return instance;
    }

    public void addExerciseToDatabase(Exercise exercise){
        int id = this.allExercises.size();
        this.mDatabase.child(String.valueOf(id)).setValue(exercise);
    }

    private void listenToExercises(){
        this.mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                allExercises.clear();
                for (DataSnapshot snp: snapshot.getChildren()) {
                    allExercises.add(snp.getValue(Exercise.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ExerciseDAL.listenToExercises",error.getMessage());
                Log.e("ExerciseDAL.listenToExercises",error.getDetails());
            }
        });
    }

    public ArrayList<Exercise> getExercisesForUser(User user){
        ArrayList<Exercise> arr = new ArrayList<Exercise>();
        arr.addAll(this.allExercises.stream().filter( exercise -> exercise.isGenderExercise() == user.getGender()).collect(Collectors.toList()));
        return arr;
    }
}
