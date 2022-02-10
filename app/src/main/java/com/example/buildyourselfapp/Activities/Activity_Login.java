package com.example.buildyourselfapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildyourself.R;
import com.example.buildyourselfapp.DAL.ExerciseDAL;
import com.example.buildyourselfapp.DAL.MealDAL;
import com.example.buildyourselfapp.DAL.UsersDAL;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener {

    private Button register, login;
    private TextView email, password;
    private UsersDAL userDAL;
    private MealDAL mealDAL;
    private ExerciseDAL exerciseDAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.userDAL = UsersDAL.getInstance();
        this.mealDAL = MealDAL.getInstance();
        this.exerciseDAL = ExerciseDAL.getInstance();
        findViews();
        initViews();


        //Meal newMeal = new Meal("salad","hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,0,http//......);
        //this.mealDAL.addMealToDatabase(newMeal);
       // addExerciseForWoman();
        //this.exerciseDAL.addExerciseToDatabase(.....);
      //  addMeal();
    }
//    private void addMeal() {
//        ArrayList<Meal> arrMeals = new ArrayList<>();
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade","Ingredients: 500 grams of fresh chicken breast before cooking Lemon juice from a little lemon A tablespoon of honey Chopped garlic clove Half a teaspoon of paprika Half a cup of chopped coriander A quarter teaspoon of salt",
//                218,35,7,4,1,3,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg"
//        ,true));
//
//        arrMeals.add( new Meal("Borax tuna from rice shelves",
//                "Ingredients: 14 units of large rice leaves, diameter 22 cm, for filling: 2 cans of tuna in water One egg (L) 250 g cottage 3% fat 150 grams of yellow cheese 9% grated fat A quarter teaspoon of black pepper",
//                86,10,7,2,1,2,
//                "https://saharkazes.co.il/wp-content/uploads/2022/01/egg-roll-2680478_1920.jpg" ,true));
//
//        arrMeals.add( new Meal("Chicken breast and vegetable roulade",
//                "Ingredients:3 pcs chicken breast (not thin schnitzels, but whole chicken breast) ,Medium-sized onions ,2 cloves crushed garlic ,Red gamba cut into thin strips , Yellow gamba cut into thin strips ,Carrots - two medium units without the peel ,Zucchini ,celery ,A handful of chopped parsley , Half a teaspoon of paprika ,Salt a flat teaspoon ,A tablespoon of canola oil",
//                210,32,8,5,1,5,
//                "https://saharkazes.co.il/wp-content/uploads/2020/12/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%99%D7%A8%D7%A7%D7%95%D7%AA-%D7%9E%D7%9E%D7%95%D7%9C%D7%90%D7%99%D7%9D.jpeg" ,true));
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,4,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,5,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//       ///////////////////////////////////////bulk man //////////////////////////////////////////////////////
//
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,2,1,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,2,2,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,2,3,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,2,4,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,2,5,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,true));
//
//        ///////////////////////////////////// cut woman //////////////////////////////////////////////////////
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,1,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg" ,false));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,2,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,3,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,4,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,5,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
///////////////////////////////////////////////////////bulk woman ////////////////////////////////////////////////////////////////////////////
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,1,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,2,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,3,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,4,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//
//        arrMeals.add( new Meal("Chicken breast in lemon and honey marinade",
//                "hjdgfjhsdgf",300.0,330.0,330.0,300.0,1,5,
//                "https://saharkazes.co.il/wp-content/uploads/2021/07/%D7%97%D7%96%D7%94-%D7%A2%D7%95%D7%A3-%D7%95%D7%9C%D7%99%D7%9E%D7%95%D7%9F.jpg",false));
//
//        mealDAL.addMealToDatabase(arrMeals);
//    }
//    private void addExerciseForWoman() {
//        Exercise exercise1 = new Exercise("Squat",
//                "A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.",
//                5,12,"A",false,
//                "https://upload.wikimedia.org/wikipedia/commons/8/82/Squats.svg");
//
//        Exercise exercise2 = new Exercise("Leg extension",
//                " is a type of strength training exercise. It's an excellent move for strengthening your quadriceps, which are in the front of your upper legs.",
//                3,12,"A",false,
//                "https://www.burnthefatinnercircle.com/members/images/1636.jpg");
//
//        Exercise exercise3 = new Exercise("Leg curl",
//                "The hamstring curl, also called a leg curl, is an exercise that strengthens the hamstrings",
//                4,12,"A",false,
//                "https://www.burnthefatinnercircle.com/members/images/1255.jpg");
//
//        Exercise exercise4 = new Exercise("Lunge",
//                "A lunge is a lower body exercise that involves stepping and bending your front and back leg.",
//                4,12,"A",false,
//                "https://www.spotebi.com/wp-content/uploads/2014/10/lunges-exercise-illustration.jpg");
//
//        Exercise exercise5 = new Exercise("Bench press",
//                "T a lift or exercise in which a weight is raised by extending the arms upward while lying on a bench.",
//                4,12,"A",false,
//                "https://s3.amazonaws.com/prod.skimble/assets/2289486/image_iphone.jpg");
//
//
//        Exercise exercise6 = new Exercise("Chest fly",
//                "The dumbbell chest fly is an upper body exercise that can help to strengthen the chest and shoulders.",
//                4,15,"A",false,
//                "https://www.burnthefatinnercircle.com/members/images/1528.jpg");
//
//        Exercise exercise7 = new Exercise("Triceps pushDown",
//                "A tricep pushdown is an isolation exercise designed to target your triceps muscles.",
//                3,12,"A",false,
//                "https://global-uploads.webflow.com/5d1d0d3f53ced35a29dbe169/5de7af82dd80e669098c020a_tricep-pushdown-anabolic-aliens.jpg");
//
//        Exercise exercise8 = new Exercise("Triceps Extension",
//                "The Triceps Extension is an isolation movement that helps develop and strengthen the triceps",
//                3,12,"A",false,
//                "https://www.burnthefatinnercircle.com/members/images/1622.jpg");
//
//        Exercise exercise9 = new Exercise("Aerobic Workout",
//                "Using an elliptical trainer or Walking or Rowing for 15-20 min",
//                0,0,"A",false,
//                "https://i5.walmartimages.com/asr/0d1b7533-eb26-49eb-92b3-c115ddf76e61_1.6ca23f9a37caaf965f0a595050255e82.jpeg");
//
//        Exercise exercise10 = new Exercise("Stretch exercise",
//                "Stand with your feet hip-width apart. Tighten your belly and pull your shoulders back for 5 min",
//                0,0,"A",false,
//                "https://cdn3.vectorstock.com/i/1000x1000/40/77/body-stretch-exercises-vector-25164077.jpg");
//
//        /////////////////////////////////B////////////////////////////////////////////////////////////////////
//        Exercise exercise11 = new Exercise("Pull down",
//                "The pulldown exercise works the back muscles and is performed at a workstation with adjustable resistance, usually plates.",
//                4,12,"B",false,
//                "https://weighttraining.guide/wp-content/uploads/2016/05/wide-grip-lat-pull-down-resized.png");
//
//        Exercise exercise12 = new Exercise("Behind the neck lat pullDown",
//                "can be performed either standing up or sat down. To do them, you start facing the machine and then reach up to grip the handles",
//                4,12,"B",false,
//                "https://i0.wp.com/24legworkouts.com/wp-content/uploads/2021/07/behind-the-neck-lat-pulldown.jpg?resize=300%2C203&ssl=1");
//
//        Exercise exercise13 = new Exercise("Seated cable row",
//                "is a compound exercise that utilizes a weighted horizontal cable row machine to work muscle groups in your back and arms",
//                4,12,"B",false,
//                "https://s3.amazonaws.com/prod.skimble/assets/1816205/image_iphone.jpg");
//
//        Exercise exercise14 = new Exercise("upright row",
//                " is a weight training exercise performed by holding a weight with an overhand grip and lifting it straight up to the collarbone",
//                3,12,"B",false,
//                "https://s3.amazonaws.com/prod.skimble/assets/1804944/image_iphone.jpg");
//
//        Exercise exercise15 = new Exercise("Dumbbell Shoulder press",
//                "known as a dumbbell shoulder press, is a weightlifting exercise that targets muscles throughout your body"
//                ,3,12,"B",false,
//                "https://s3.amazonaws.com/prod.skimble/assets/1904357/image_iphone.jpg");
//
//
//        Exercise exercise16 = new Exercise("Biceps curl",
//                "an exercise in which you bend your arm towards your body at the elbow in order to make your biceps",
//                3,12,"B",false,
//                "https://i.pinimg.com/originals/f8/ce/55/f8ce55f3b09598ddf9f598d0cc455255.png");
//
//        Exercise exercise17 = new Exercise("Crunch",
//                "Lie down on your back. Plant your feet on the floor, hip-width apart. Bend your knees and place your arms across your chest. Contract your abs and inhale.",
//                3,12,"B",false,
//                "https://i.pinimg.com/236x/e2/e9/55/e2e9552eeb94c807a7955a9b16fb4565.jpg");
//
//        Exercise exercise18 = new Exercise("Russian twist",
//                " Exhale as you twist to the left, punching your right arm over to the left side.",
//                3,15,"B",false,
//                "https://s3.amazonaws.com/prod.skimble/assets/2287890/image_iphone.jpg");
//
//        Exercise exercise19 = new Exercise("Plank",
//                " Static training occurs when the body moves very little or not at all while contracting the muscle fibers 1 min for set ",
//                3,0,"B",false,
//                "https://i.stack.imgur.com/0RwKx.jpg");
//        Exercise exercise20 = new Exercise("Aerobic Workout",
//                "Using an elliptical trainer or Walking or Rowing for 15-20 min",
//                0,0,"A",false,
//                "https://i5.walmartimages.com/asr/0d1b7533-eb26-49eb-92b3-c115ddf76e61_1.6ca23f9a37caaf965f0a595050255e82.jpeg");
////////////////////////////////////////man//////////////////////////////////////////////////////////////////////
//        Exercise exercise21 = new Exercise("Squat",
//                "A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.",
//                5,12,"A",true,
//                "https://upload.wikimedia.org/wikipedia/commons/8/82/Squats.svg");
//
//        Exercise exercise22 = new Exercise("Leg extension",
//                " is a type of strength training exercise. It's an excellent move for strengthening your quadriceps, which are in the front of your upper legs.",
//                3,12,"A",true,
//                "https://www.burnthefatinnercircle.com/members/images/1636.jpg");
//
//        Exercise exercise23 = new Exercise("Leg curl",
//                "The hamstring curl, also called a leg curl, is an exercise that strengthens the hamstrings",
//                4,12,"A",true,
//                "https://www.burnthefatinnercircle.com/members/images/1255.jpg");
//
//        Exercise exercise24 = new Exercise("Bench press",
//                "T a lift or exercise in which a weight is raised by extending the arms upward while lying on a bench.",
//                4,12,"A",true,
//                "https://s3.amazonaws.com/prod.skimble/assets/2289486/image_iphone.jpg");
//
//        Exercise exercise25 = new Exercise("Bench press upper",
//                "is an upper-body weight training exercise in which the trainee presses a weight upwards while lying on a weight training bench.",
//                4,12,"A",true,
//                "https://dagodsfitnesshome.files.wordpress.com/2019/03/1669.jpg");
//
//        Exercise exercise26 = new Exercise("Chest fly",
//                "The dumbbell chest fly is an upper body exercise that can help to strengthen the chest and shoulders.",
//                4,15,"A",true,
//                "https://www.burnthefatinnercircle.com/members/images/1528.jpg");
//
//        Exercise exercise27 = new Exercise("Triceps PushDown one arm",
//                "Slowly extend your arm down, keeping your elbow at your side, until your forearm and hand reaches your upper thigh",
//                3,12,"A",true,
//                "https://images.squarespace-cdn.com/content/v1/55e406fbe4b0b03c5e7543ae/1493080062990-1M7JZD70PLB89376H6ZX/One+Arm+Cable+Triceps+Pushdowns+%28Reverse+Grip%29");
//
//        Exercise exercise28 = new Exercise("Triceps pushDown",
//                "A tricep pushdown is an isolation exercise designed to target your triceps muscles.",
//                3,12,"A",true,
//                "https://global-uploads.webflow.com/5d1d0d3f53ced35a29dbe169/5de7af82dd80e669098c020a_tricep-pushdown-anabolic-aliens.jpg");
//
//        Exercise exercise29 = new Exercise("Triceps Extension",
//                "The Triceps Extension is an isolation movement that helps develop and strengthen the triceps",
//                3,12,"A",true,
//                "https://www.burnthefatinnercircle.com/members/images/1622.jpg");
//        Exercise exercise30 = new Exercise("Aerobic Workout",
//                "Using an elliptical trainer or Walking or Rowing for 15-20 min",
//                0,0,"A",false,
//                "https://i5.walmartimages.com/asr/0d1b7533-eb26-49eb-92b3-c115ddf76e61_1.6ca23f9a37caaf965f0a595050255e82.jpeg");
//
//        /////////////////////////////////B////////////////////////////////////////////////////////////////////
//        Exercise exercise31 = new Exercise("Pull down",
//                "The pulldown exercise works the back muscles and is performed at a workstation with adjustable resistance, usually plates.",
//                4,12,"B",true,
//                "https://weighttraining.guide/wp-content/uploads/2016/05/wide-grip-lat-pull-down-resized.png");
//
//        Exercise exercise32 = new Exercise("Behind the neck lat pullDown",
//                "can be performed either standing up or sat down. To do them, you start facing the machine and then reach up to grip the handles",
//                4,12,"B",true,
//                "https://i0.wp.com/24legworkouts.com/wp-content/uploads/2021/07/behind-the-neck-lat-pulldown.jpg?resize=300%2C203&ssl=1");
//
//        Exercise exercise33 = new Exercise("Seated cable row",
//                "is a compound exercise that utilizes a weighted horizontal cable row machine to work muscle groups in your back and arms",
//                4,12,"B",true,
//                "https://s3.amazonaws.com/prod.skimble/assets/1816205/image_iphone.jpg");
//
//        Exercise exercise34 = new Exercise("Cabal one arm literal raise",
//                " Is a shoulder exercise that targets the medial or middle head of the deltoid muscle.",
//                3,12,"B",true,
//                "https://www.burnthefatinnercircle.com/members/images/1656.jpg");
//
//        Exercise exercise35 = new Exercise("Dumbbell Shoulder press",
//                "known as a dumbbell shoulder press, is a weightlifting exercise that targets muscles throughout your body"
//                ,3,12,"B",true,
//                "https://s3.amazonaws.com/prod.skimble/assets/1904357/image_iphone.jpg");
//
//        Exercise exercise36 = new Exercise("Revers cable crossover",
//                "Grip the handle, across your body in a neutral grip, with both hands. Keeping only a slight bend at your elbow, pull the cable back across your body using the muscles in your back.",
//                3,12,"B",true,
//                "https://i.pinimg.com/originals/90/16/b8/9016b8476acd327cecdb20e84c27910c.jpg");
//
//        Exercise exercise37 = new Exercise("One arm dumbbell preacher curl",
//                "Curl the dumbbell in towards your chin and upper chest in a single smooth arc. Hold for a count of one while squeezing your biceps.",
//                3,12,"B",true,
//                "https://st2.depositphotos.com/8546304/11422/i/950/depositphotos_114227956-stock-photo-one-arm-dumbbell-preacher-curl.jpg");
//
//        Exercise exercise38 = new Exercise("Biceps curl",
//                "an exercise in which you bend your arm towards your body at the elbow in order to make your biceps",
//                3,12,"B",true,
//                "https://i.pinimg.com/originals/f8/ce/55/f8ce55f3b09598ddf9f598d0cc455255.png");
//
//        Exercise exercise39 = new Exercise("Crunch",
//                "Lie down on your back. Plant your feet on the floor, hip-width apart. Bend your knees and place your arms across your chest. Contract your abs and inhale.",
//                3,12,"B",true,
//                "https://i.pinimg.com/236x/e2/e9/55/e2e9552eeb94c807a7955a9b16fb4565.jpg");
//
//        Exercise exercise40 = new Exercise("Russian twist",
//                " Exhale as you twist to the left, punching your right arm over to the left side.",
//                3,15,"B",true,
//                "https://s3.amazonaws.com/prod.skimble/assets/2287890/image_iphone.jpg");
//
//        ArrayList<Exercise> arrEx = new ArrayList<>();
//        arrEx.add(exercise1);
//        arrEx.add(exercise2);
//        arrEx.add(exercise3);
//        arrEx.add(exercise4);
//        arrEx.add(exercise5);
//        arrEx.add(exercise6);
//        arrEx.add(exercise7);
//        arrEx.add(exercise8);
//        arrEx.add(exercise9);
//        arrEx.add(exercise10);
//        arrEx.add(exercise11);
//        arrEx.add(exercise12);
//        arrEx.add(exercise13);
//        arrEx.add(exercise14);
//        arrEx.add(exercise15);
//        arrEx.add(exercise16);
//        arrEx.add(exercise17);
//        arrEx.add(exercise18);
//        arrEx.add(exercise19);
//        arrEx.add(exercise20);
//        arrEx.add(exercise21);
//        arrEx.add(exercise22);
//        arrEx.add(exercise23);
//        arrEx.add(exercise24);
//        arrEx.add(exercise25);
//        arrEx.add(exercise26);
//        arrEx.add(exercise27);
//        arrEx.add(exercise28);
//        arrEx.add(exercise29);
//        arrEx.add(exercise30);
//        arrEx.add(exercise31);
//        arrEx.add(exercise32);
//        arrEx.add(exercise33);
//        arrEx.add(exercise34);
//        arrEx.add(exercise35);
//        arrEx.add(exercise36);
//        arrEx.add(exercise37);
//        arrEx.add(exercise38);
//        arrEx.add(exercise39);
//        arrEx.add(exercise40);
//
//        this.exerciseDAL.addExerciseToDatabase(arrEx);
//    }


    private void findViews() {
        //Edit Texts
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        //Buttons
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);
    }

    private void initViews() {
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register) {
            startActivity(new Intent(Activity_Login.this, Activity_Register.class));
        } else if (v.getId() == R.id.btn_login) {
            String emailTxt = email.getText().toString(),
                    passwordTxt = password.getText().toString();
            if ((emailTxt != null && passwordTxt != null)
                    && (!emailTxt.isEmpty() && !passwordTxt.isEmpty())) {
                Log.d("TAJ", "emailTxt: " + emailTxt + " passwordTxt: " + passwordTxt);

                if(userDAL.LogIn(emailTxt,passwordTxt)) {
                    int planTemp = this.userDAL.getCurrentUser().getPlan();
                    if(planTemp==0) {
                        startActivity(new Intent(Activity_Login.this, Activity_Plan.class));
                    }else{
                        startActivity(new Intent(Activity_Login.this, Activity_Meals.class));
                    }
                }
                else{
                    Toast.makeText(Activity_Login.this, "Error, email or password incorrect!",
                            Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(Activity_Login.this, "Error, email and password must be provided!",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}