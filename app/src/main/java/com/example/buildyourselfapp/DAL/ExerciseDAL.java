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
import java.util.Calendar;
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

    public void addExerciseToDatabase(ArrayList<Exercise> exercise){
        for (int i = 0; i < exercise.size(); i++) {
            this.mDatabase.child(String.valueOf(i)).setValue(exercise.get(i));
        }
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
        String planByDay = this.getPlanByDay();
        arr.addAll(this.allExercises.stream().filter( exercise -> exercise.isGenderExercise() == user.getGender() && exercise.getDayOfWorkout().equalsIgnoreCase(planByDay)).collect(Collectors.toList()));
        return arr;
    }

    private String getPlanByDay() {
        String retval = "";
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        retval = day%2==0?"A":"B"; //for odd day returns B else A
        return retval;
    }
}
