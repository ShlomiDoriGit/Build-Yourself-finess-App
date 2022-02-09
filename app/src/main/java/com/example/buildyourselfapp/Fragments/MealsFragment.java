package com.example.buildyourselfapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.buildyourself.R;


public class MealsFragment extends Fragment {

    ImageView[] images;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meals, container, false);
        findViews(view);
        initData();
        return view;
    }

    private void initData() {
        
    }

    private void findViews(View view) {
        //images
        this.images = new ImageView[]{
        view.findViewById(R.id.meal1_img)
        };
    }


}