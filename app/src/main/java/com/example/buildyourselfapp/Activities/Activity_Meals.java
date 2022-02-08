package com.example.buildyourselfapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.Models.Meal;

import java.util.ArrayList;

public class Activity_Meals extends AppCompatActivity {
    private ArrayList<Meal> mealList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
    }




}