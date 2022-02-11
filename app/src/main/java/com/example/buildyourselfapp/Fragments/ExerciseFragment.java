package com.example.buildyourselfapp.Fragments;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buildyourself.R;
import com.example.buildyourselfapp.Adapters.AdapterExercise;
import com.example.buildyourselfapp.Adapters.Adapter_Exercise;
import com.example.buildyourselfapp.DAL.ExerciseDAL;
import com.example.buildyourselfapp.DAL.MealDAL;
import com.example.buildyourselfapp.DAL.UsersDAL;
import com.example.buildyourselfapp.Models.Exercise;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.example.buildyourselfapp.Models.Meal;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class ExerciseFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private int currentPosition;

    private UsersDAL usersDAL;
    private ExerciseDAL exerciseDAL;
    ArrayList<Exercise> exercisesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exercises, container, false);
        this.usersDAL = UsersDAL.getInstance();
        this.exerciseDAL = ExerciseDAL.getInstance();
        this.exercisesList = this.exerciseDAL.getExercisesForUser(this.usersDAL.getCurrentUser());
        this.findViews();
        this.setAdapter();
        this.setFocusToItem(0);
        return view;
    }


    public void setAdapter(){
        AdapterExercise adpater = new AdapterExercise(this.exercisesList,getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adpater);
    }

    private void findViews() {
        this.recyclerView = this.view.findViewById(R.id.recyclerview);
    }

    public void setFocusToItem(int position){
        recyclerView.scrollToPosition(position);
        this.currentPosition = position;
    }

    public int getCurrentPosition(){
        return this.currentPosition;
    }
    public int getListSize(){
        return this.exercisesList.size();
    }









}