package com.example.gadsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gadsapp.R;
import com.example.gadsapp.adapter.LeaderBoardPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button button;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar_leaderboard);
        setSupportActionBar(toolbar);




        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        button = findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                startActivity(intent);
            }
        });

        LeaderBoardPagerAdapter householdPagerAdapter = new LeaderBoardPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(householdPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);




        }




}