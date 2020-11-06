package com.example.gadsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsapp.R;
import com.example.gadsapp.model.LearningLeadersModelData;

import java.util.ArrayList;
import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {
    private final List<LearningLeadersModelData> learningLeadersModelData;
    private final Context context;


    public LearningLeadersAdapter(List<LearningLeadersModelData> learningLeadersModelData, Context context) {
        this.learningLeadersModelData = learningLeadersModelData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.learning_leaders_itemview, parent, false);
        return new LearningLeadersAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.learnerName.setText(learningLeadersModelData.get(position).getName());
        holder.learningHours.setText(String.valueOf(learningLeadersModelData.get(position).getHours()));
        holder.learnerCountry.setText(learningLeadersModelData.get(position).getCountry());

    }

    @Override
    public int getItemCount() {

        return learningLeadersModelData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView learnerName, learningHours, learnerCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.learner_name);
            learningHours = itemView.findViewById(R.id.learning_hours);
            learnerCountry = itemView.findViewById(R.id.learning_country);
        }
    }
}
