package com.example.gadsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.gadsapp.R;

public class SplashScreen extends AppCompatActivity {
    private static int splashTimeOut = 5000;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.welcome_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LearningLeadersActivity.class);
                startActivity(intent);
                finish();
            }
        },splashTimeOut);

        Animation splashAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_animation);
        imageView.startAnimation(splashAnimation);
    }
}