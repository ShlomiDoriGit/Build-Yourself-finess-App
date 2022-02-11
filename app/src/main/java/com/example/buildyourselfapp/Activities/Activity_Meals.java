package com.example.buildyourselfapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.Fragments.MealsFragment;
import com.example.buildyourselfapp.Models.Meal;

import java.util.ArrayList;

public class Activity_Meals extends AppCompatActivity {

    private MealsFragment fragment;
    private ImageButton btn_plan;
    private ImageButton btn_exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        this.findViews();
        this.btnListener();
        this.fragment = new MealsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_meals,fragment).commit();
    }

    public void btnListener(){

        this.btn_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Meals.this, Activity_Plan.class));
            }
        });

        this.btn_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Meals.this, Activity_Exercise.class));
            }
        });
    }


    private void findViews() {
        this.btn_plan = findViewById(R.id.btn_plan);
        this.btn_exercise = findViewById(R.id.btn_exercise);
    }


}