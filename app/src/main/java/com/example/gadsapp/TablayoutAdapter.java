package com.example.gadsapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TablayoutAdapter extends FragmentPagerAdapter {

    // constructor
    public TablayoutAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }

    // Switching between the fragments
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LearningLeadersFragment learningLeadersFragment = new LearningLeadersFragment();
                return learningLeadersFragment;
            case 1:
                SkillLeadersFragment skillLeadersFragment = new SkillLeadersFragment();
                return skillLeadersFragment;
            default:
                return null;
        }
    }

    // sets the title for each fragment
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        if (position == 0){
            title = "Learning Leaders";
        }else {
            title = "Skill IQ Leaders";
        }
        return title;
    }

    // This counts the total number of tabs available
    @Override
    public int getCount() {

        return 2;
    }
}
