package com.example.buildyourselfapp.Adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buildyourself.R;
import com.example.buildyourselfapp.Models.Exercise;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class AdapterExercise extends RecyclerView.Adapter<AdapterExercise.ExerciseViewHolder>{

    private ArrayList<Exercise> exercisesList;
    private Activity activity;

    public AdapterExercise(ArrayList<Exercise> exercisesList, Activity activity) {
        this.exercisesList = exercisesList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterExercise.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_exercise_small, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExercise.ExerciseViewHolder holder, int position) {
        Exercise ex = this.exercisesList.get(position);
        String setsAndReps = ex.getSets()+"x"+ex.getReps();
        holder.exercise_LBL_name.setText(ex.getName());
        holder.exercise_LBL_description.setText(ex.getDescription());
        holder.exercise_LBL_dayOfWorkout.setText(ex.getDayOfWorkout());
        holder.exercise_LBL_setsAndReps.setText(setsAndReps);
        Glide.with(this.activity).load(ex.getUrl()).into(holder.exercise_IMG_image);
    }

    @Override
    public int getItemCount() {
        return this.exercisesList.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {

        public AppCompatImageView exercise_IMG_image;
        public MaterialTextView exercise_LBL_name;
        public MaterialTextView exercise_LBL_description;
        public MaterialTextView exercise_LBL_setsAndReps;
        public MaterialTextView exercise_LBL_dayOfWorkout; // A or B

        public ExerciseViewHolder(final View itemView) {
            super(itemView);
            this.exercise_IMG_image = itemView.findViewById(R.id.exercise_IMG_image);
            this.exercise_LBL_name = itemView.findViewById(R.id.exercise_LBL_name);
            this.exercise_LBL_description = itemView.findViewById(R.id.exercise_LBL_description);
            this.exercise_LBL_setsAndReps = itemView.findViewById(R.id.exercise_LBL_setsAndReps);
            this.exercise_LBL_dayOfWorkout = itemView.findViewById(R.id.exercise_LBL_dayOfWorkout);


        }
    }
}
