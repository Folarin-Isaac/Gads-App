package com.example.gadsapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.gadsapp.fragment.LearningLeadersFragment;
import com.example.gadsapp.fragment.SkillLeadersFragment;

public class LeaderBoardPagerAdapter extends FragmentStatePagerAdapter {


    public LeaderBoardPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LearningLeadersFragment();
            case 1:
                return new SkillLeadersFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        if (position == 0){
            title = "Learning Leaders";
        }
        else {
            title = "SkillIQ Leaders";
        }
        return title;
    }
}
