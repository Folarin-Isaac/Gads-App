package com.example.gadsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsapp.R;
import com.example.gadsapp.model.SkillIQModelData;

import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.SkillIQViewHolder> {
    private final Context context;
    private final List<SkillIQModelData> skillIQModelData;

    public SkillIQAdapter(Context context, List<SkillIQModelData> skillIQModelData) {
        this.context = context;
        this.skillIQModelData = skillIQModelData;
    }

    @NonNull
    @Override
    public SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.skillsiq_leaders_itemview, parent, false);
        return new SkillIQAdapter.SkillIQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQViewHolder holder, int position) {
        holder.learnerName.setText(skillIQModelData.get(position).getName());
        holder.learnerScore.setText(String.valueOf(skillIQModelData.get(position).getScore()));
        holder.learnerCountry.setText(skillIQModelData.get(position).getCountry());

    }


    @Override
    public int getItemCount() {
        return skillIQModelData.size();
    }

    public static class SkillIQViewHolder extends RecyclerView.ViewHolder{
        final TextView learnerName, learnerScore, learnerCountry;


        public SkillIQViewHolder(@NonNull View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.skilliq_learner_name);
            learnerScore = itemView.findViewById(R.id.skilliq_learner_score);
            learnerCountry = itemView.findViewById(R.id.skilliq_learner_country);
        }
    }
}
