package com.example.buildyourselfapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.DAL.UsersDAL;

import java.util.zip.Inflater;

public class Activity_Plan extends AppCompatActivity {

    private ImageView cutImage ;
    private ImageView bulkImage ;
    private Intent intent ;
    private LinearLayout bulk_plan_layout ;
    private LinearLayout cut_plan_layout ;
    private UsersDAL userDAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        this.userDAL = UsersDAL.getInstance();
        boolean isMen = this.userDAL.getCurrentUser().getGender();
        findView(isMen);


    }

    public void findView(boolean isMen) {
        cutImage = findViewById(R.id.img_cut);
        bulkImage = findViewById(R.id.img_bulk);
        bulk_plan_layout = findViewById(R.id.bulk_plan_layout);
        cut_plan_layout = findViewById(R.id.cut_plan_layout);
        if(!isMen){
            cutImage.setBackgroundResource(R.drawable.cut_w);
            bulkImage.setBackgroundResource(R.drawable.bulk_w);
        }
    }
    public void editActions(View view){

        cut_plan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAL.setPlan(1);
                Intent intent = new Intent(getApplicationContext(), Activity_Exercise.class);
                startActivity(intent);
            }
        });

        bulk_plan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAL.setPlan(2);
                Intent intent = new Intent(getApplicationContext(), Activity_Exercise.class);
                startActivity(intent);
            }
        });
    }
}