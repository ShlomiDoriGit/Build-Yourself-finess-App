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
//
//
//        ArrayList<Movie> movies = DataManager.generateMovies();
//
//        Adapter_Movie adapter_movie = new Adapter_Movie(this, movies);
//
//
//        // Grid
//        main_LST_movies.setLayoutManager(new GridLayoutManager(this, 2));
//
//        // Vertically
//        //main_LST_movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//
//
//        main_LST_movies.setHasFixedSize(true);
//        main_LST_movies.setItemAnimator(new DefaultItemAnimator());
//        main_LST_movies.setAdapter(adapter_movie);
//
    }
}
