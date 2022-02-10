package com.example.buildyourselfapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildyourself.R;

public class Activity_Exercise extends AppCompatActivity {

    private RecyclerView exercise_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        exercise_list = findViewById(R.id.exercise_list);
    }
}
