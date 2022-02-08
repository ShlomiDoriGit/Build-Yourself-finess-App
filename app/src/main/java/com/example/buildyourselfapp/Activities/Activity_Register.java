package com.example.buildyourselfapp.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.DAL.UsersDAL;
import com.example.buildyourselfapp.Models.User;

public class Activity_Register extends AppCompatActivity  implements View.OnClickListener {

    private Button back,register;
    private EditText Name, email, password, height, weight;
    private CheckBox male, female;
    private final User user = new User();
    //private  UsersDAL usersDAL ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        findViews();
        initViews();
    }


    private void findViews() {
        //Edit Texts
        Name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        height = (EditText) findViewById(R.id.input_height);
        weight = (EditText) findViewById(R.id.input_weight);
        //Buttons
        back = (Button) findViewById(R.id.btn_go_back_to_log_in);
        register = (Button) findViewById(R.id.btn_register);
        //CheckBox
        male = (CheckBox) findViewById(R.id.checkbox_male);
        female = (CheckBox) findViewById(R.id.checkbox_female);
    }

    private void initViews() {
        back.setOnClickListener(this);
        register.setOnClickListener(this);
        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go_back_to_log_in:
                startActivity(new Intent(Activity_Register.this, Activity_Login.class));
                break;
            case R.id.btn_register:
                if (validateFields()) {
                    if(UsersDAL.getInstance().Register(user) != null){
                        Log.d("TAJ","success!");
                        startActivity(new Intent(Activity_Register.this, Activity_Login.class));
                    }
                }
                break;
            case R.id.checkbox_male:
                user.setGender(true);
                break;
            case R.id.checkbox_female:
                user.setGender(false);
                break;
            default:
                break;
        }
    }

    private boolean validateFields() {
        if (TextUtils.isEmpty(Name.getText())) {
            Name.setError("Full name is required!");
            Name.requestFocus();
            return false;
        }  else if (TextUtils.isEmpty(email.getText()) ||
                !Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {
            email.setError("Valid email is required!");
            email.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(weight.getText())) {
            password.setError("Password is required!");
            password.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(password.getText())) {
            height.setError("Height is required!");
            height.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(height.getText())) {
            weight.setError("Weight is required!");
            weight.requestFocus();
            return false;
        } else if (user.getGender() == null) {
            female.setError("Gender is required!");
            return false;
        } else {
            user.setUsername(Name.getText().toString());
            user.setPassword(password.getText().toString());
            user.setEmail(email.getText().toString());
            user.setWeight(Double.parseDouble(weight.getText().toString()));
            user.setHeight(Double.parseDouble(height.getText().toString()));
            return true;
        }
    }
}