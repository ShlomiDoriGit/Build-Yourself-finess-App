package com.example.buildyourselfapp.DAL;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.buildyourselfapp.Models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UsersDAL {

    private static UsersDAL instance;
    private DatabaseReference mDatabase;
    private ArrayList<User> allUsers;
    private User currentUser;

    private UsersDAL() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child(User.class.getSimpleName());
        this.allUsers = new ArrayList<>();
        this.listenToUsers();
    }

    public static UsersDAL getInstance(){
        if(instance==null)
            instance = new UsersDAL();
        return instance;
    }

    public Task<Void> Register(User _user)
    {
        if(_user != null){
            if(!this.isEmailExists(_user.getEmail())){
                return this.mDatabase.child(_user.getEmail()).setValue(_user);
            }
        }
        return null;
    }

    public Boolean LogIn(String email, String password){
        this.currentUser = this.allUsers.stream().
                filter(user -> email.equals(user.getEmail())&&
                password.equals(user.getPassword())).
                findFirst().
                orElse(null);
        Log.d("UsersDAL.listenToUsers", String.valueOf(this.currentUser));
        Log.d("UsersDAL.listenToUsers", String.valueOf(this.allUsers));
        return this.currentUser!=null?true:false;
    }

    private Boolean isEmailExists(String email){
        User temp = this.allUsers.stream().
                filter(user -> email.equals(user.getEmail())).
                findFirst().orElse(null);
        return temp!=null?true:false;
    }

    private void listenToUsers(){
        this.mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                allUsers.clear();
                for (DataSnapshot snp: snapshot.getChildren()) {
                    allUsers.add(snapshot.getValue(User.class));
                    Log.d("UsersDAL.listenToUsers", "@@@@@@@@@@@@@@");
                    Log.d("UsersDAL.listenToUsers", String.valueOf(snapshot.getValue(User.class)));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("UsersDAL.listenToUsers",error.getMessage());
                Log.e("UsersDAL.listenToUsers",error.getDetails());
            }
        });
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
