package com.example.buildyourselfapp.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.Fragments.ExerciseFragment;
import com.example.buildyourselfapp.Fragments.MealsFragment;
import com.google.android.material.button.MaterialButton;

public class Activity_Exercise extends AppCompatActivity {

    private Button btn;
    private ImageButton btn_plan;
    private ImageButton btn_meal;

    private boolean isplaying;
    private CountDownTimer timer;
    private int timeExercise;
    private int counter;
    private MediaPlayer player;
    private ExerciseFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        this.isplaying = false;
        this.timeExercise = 5;
        this.counter = timeExercise;
        this.findViews();
        this.btnListener();
        this.fragment = new ExerciseFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame_exercise,fragment).commit();

    }
    public void timerStart(long timeLengthMilli){
        this.timer = new CountDownTimer((timeLengthMilli)*1000, 1000){
            public void onTick(long millisUntilFinished){
                int minutes = (counter % 3600) / 60;
                int seconds = counter % 60;
                String mm = minutes < 10 ? "0" + minutes : "" + minutes;
                String ss = seconds < 10 ? "0" + seconds : "" + seconds;
                btn.setText(mm+":"+ss);
                counter--;

            }
            public  void onFinish(){
                    counter = timeExercise;
                    int currentPos = fragment.getCurrentPosition();
                    int maxPos = fragment.getListSize();
                    if(currentPos<maxPos){
                        player = MediaPlayer.create(getApplicationContext(),R.raw.coin_sound);
                        player.start();
                        player.setOnCompletionListener(MediaPlayer::pause);
                        int newPos = currentPos+1;
                        fragment.setFocusToItem(newPos);
                        timerStart(counter);
                    }else{
                        Toast.makeText(Activity_Exercise.this, "You complete your workout well done!",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        };
        timer.start();
    }

    public void btnListener(){
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isplaying = !isplaying;
                if(!isplaying){
                    timer.cancel();

                }else{
                    timerStart(counter);
                }
            }
        });

        this.btn_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Exercise.this, Activity_Plan.class));
            }
        });

        this.btn_meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Exercise.this, Activity_Meals.class));
            }
        });
    }


    private void findViews() {
       this.btn = findViewById(R.id.btn_timer);
       this.btn_plan = findViewById(R.id.btn_plan);
       this.btn_meal = findViewById(R.id.btn_meal);
    }


}
