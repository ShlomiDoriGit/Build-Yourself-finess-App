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
import com.example.buildyourselfapp.Models.User;

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
        User user = this.usersDAL.getCurrentUser();
        this.meals = this.mealDAL.getMealsForUser(user);
        findViews(view);
        initData();
        return view;
    }

    private void initData() {
        for (int i = 0; i < meals.size(); i++) {
            Meal mm = this.meals.get(i);
            String name = mm.getName();
            String desc = mm.getDescription();
            this.names[i].setText(name);
            this.descriptions[i].setText(desc);
            this.details[i].setText("calories: "+mm.getCalories() +"        protein: "+mm.getProtein()+"        carbs: "+mm.getCarbs()+"        fats: "+mm.getFat());
            Glide.with(this).load(mm.getUrl()).into(images[i]);
        }
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