package com.example.buildyourselfapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.DAL.UsersDAL;

public class Activity_Plan extends AppCompatActivity {

    private ImageView cutImage ;
    private ImageView bulkImage ;
    private Intent intent ;
    private LinearLayout bulk_plan_layout ;
    private LinearLayout cut_plan_layout ;
   // private UsersDAL userDAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
       // intent = getIntent();
        boolean isMen = UsersDAL.getInstance().getCurrentUser().getGender();
        findView(isMen);


    }

    public void findView(boolean isMen) {
        cutImage = findViewById(R.id.img_cut);
        bulkImage = findViewById(R.id.img_bulk);
        bulk_plan_layout = findViewById(R.id.bulk_plan_layout);
        cut_plan_layout = findViewById(R.id.cut_plan_layout);
        if(!isMen){
            cutImage.setImageResource(R.drawable.cut_w);
            bulkImage.setImageResource(R.drawable.bulk_w);
        }
    }
    public void editActions(View view, boolean isMen){

        cut_plan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Exercise.class);
                intent.putExtra("plan", "cut");
                intent.putExtra("gender", isMen); // men is true , woman false
                startActivity(intent);
            }
        });

        bulk_plan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Exercise.class);
                intent.putExtra("plan", "bulk");
                intent.putExtra("gender", isMen); // men is true , woman false
                startActivity(intent);
            }
        });
    }
}