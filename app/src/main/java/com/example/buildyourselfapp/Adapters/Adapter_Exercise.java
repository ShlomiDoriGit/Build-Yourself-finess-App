package com.example.buildyourselfapp.Adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.buildyourselfapp.Models.Exercise;
import com.example.buildyourselfapp.R;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;


public class Adapter_Exercise extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity activity;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private ExerciseItemClickListener exerciseItemClickListener;


    public Adapter_Exercise(Activity activity, ArrayList<Exercise> exercises) {
        this.activity = activity;
        this.exercises = exercises;

    }
    public Adapter_Exercise setExerciseItemClickListener(ExerciseItemClickListener exerciseItemClickListener) {
        this.exerciseItemClickListener = exerciseItemClickListener;
        return this;
    }
    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.list_exercise_small, viewGroup, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ExerciseViewHolder exerciseViewHolder = (ExerciseViewHolder) holder ;
        Exercise exercise = getItem(position);
        Log.d("pttt", "position= " + position);

        exerciseViewHolder.exercise_LBL_name.setText(position + "\n" + exercise.getName());
        exerciseViewHolder.exercise_LBL_description.setText(exercise.getDescription());
        int sets = exercise.getSets();
        int reps = exercise.getReps();
        exerciseViewHolder.exercise_LBL_setsAndReps.setText(sets + " X " + reps);
        exerciseViewHolder.exercise_LBL_setsAndReps.setText(exercise.getDayOfWorkout());

        /*
          Glide
                .with(activity)
                .load(movie.getImage())
                .into(movieViewHolder.movie_IMG_image);
         */
    }
    @Override
    public int getItemCount() {
        return exercises.size();
    }

    private Exercise getItem(int position) {
        return exercises.get(position);
    }
    public interface ExerciseItemClickListener {
        void exerciseItemClicked(Exercise exercise, int position);
        void favoriteClicked(Exercise exercise, int position);
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
