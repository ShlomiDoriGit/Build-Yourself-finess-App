package com.example.buildyourselfapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.buildyourself.R;
import com.example.buildyourselfapp.DAL.MealDAL;
import com.example.buildyourselfapp.DAL.UsersDAL;
import com.example.buildyourselfapp.Models.Meal;

import java.util.ArrayList;


public class MealsFragment extends Fragment {

    ImageView[] images;
    TextView[] names;
    TextView[] descriptions;
    TextView[] details;

    private UsersDAL usersDAL;
    private MealDAL mealDAL;
    ArrayList<Meal> meals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meals, container, false);
        this.usersDAL = UsersDAL.getInstance();
        this.mealDAL = MealDAL.getInstance();
        this.meals = this.mealDAL.getMealsForUser(this.usersDAL.getCurrentUser());
        findViews(view);
        initData();
        return view;
    }

    private void initData() {
        String name = this.meals.get(0).getName();
        String desc = this.meals.get(0).getDescription();
        this.names[0].setText(name);
        this.descriptions[0].setText(desc);
        this.details[0].setText("calories: "+this.meals.get(0).getCalories() +"          protein: "+this.meals.get(0).getProtein()+"\\n\\ncarbs: "+this.meals.get(0).getCarbs()+"               fats: "+this.meals.get(0).getFat());
        Glide.with(this).load(this.meals.get(0).getUrl()).into(images[0]);
    }

    private void findViews(View view) {
        //images
        this.images = new ImageView[]{
        view.findViewById(R.id.meal1_img),
        view.findViewById(R.id.meal2_img),
        view.findViewById(R.id.meal3_img),
        view.findViewById(R.id.meal4_img),
        view.findViewById(R.id.meal5_img)
        };
        //names
        this.names = new TextView[]{
        view.findViewById(R.id.meal1_name),
        view.findViewById(R.id.meal2_name),
        view.findViewById(R.id.meal3_name),
        view.findViewById(R.id.meal4_name),
        view.findViewById(R.id.meal5_name)
        };
        //descriptions
        this.descriptions = new TextView[]{
        view.findViewById(R.id.meal1_description),
        view.findViewById(R.id.meal2_description),
        view.findViewById(R.id.meal3_description),
        view.findViewById(R.id.meal4_description),
        view.findViewById(R.id.meal5_description)
        };
        //descriptions
        this.details = new TextView[]{
                view.findViewById(R.id.meal1_details),
                view.findViewById(R.id.meal2_details),
                view.findViewById(R.id.meal3_details),
                view.findViewById(R.id.meal4_details),
                view.findViewById(R.id.meal5_details)
        };
    }


}