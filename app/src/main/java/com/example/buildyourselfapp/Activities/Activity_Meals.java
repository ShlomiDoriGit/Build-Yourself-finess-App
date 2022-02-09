package com.example.buildyourselfapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.Fragments.MealsFragment;
import com.example.buildyourselfapp.Models.Meal;

import java.util.ArrayList;

public class Activity_Meals extends AppCompatActivity {

    private MealsFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        this.fragment = new MealsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_meals,fragment).commit();
    }




}