package com.example.buildyourselfapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.Adapters.Adapter_Exercise;
import com.example.buildyourselfapp.Models.Exercise;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ExerciseFragment extends Fragment {

    private Adapter_Exercise adapter;
    private RecyclerView exercise_list;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exercises, container, false);
        exercise_list = view.findViewById(R.id.exercise_list);
        exercise_list.setHasFixedSize(true);
        setUpRecyclerView();

        return view;
    }
    public ExerciseFragment() {
    }

    public void setUpRecyclerView(){
        Query query = FirebaseDatabase.getInstance().getReference("exersice");

        FirebaseRecyclerOptions<Exercise> options = new FirebaseRecyclerOptions.Builder<Exercise>()
                .setQuery(query, Exercise.class)
                .build();

        adapter = new Adapter_Exercise(options);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        exercise_list.setLayoutManager(linearLayoutManager);
        exercise_list.setAdapter(adapter);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if (adapter != null) {
//            adapter.startListening();
//        }
//
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (adapter != null) {
//            adapter.stopListening();
//        }
//
//    }
}