package com.example.gadsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {
    private final Context context;
    private final List<LearningLeadersModelData> learningLeaderModelData;

    public LearningLeadersAdapter(Context context, List<LearningLeadersModelData> learningLeaderModelData) {
        this.context = context;
        this.learningLeaderModelData = learningLeaderModelData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        // view to inflate the layout with the recyclerview items
        View view = layoutInflater.inflate(R.layout.learning_leaders_itemview, parent, false);
        return new LearningLeadersAdapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.learning_name.setText(learningLeaderModelData.get(position).getName());
        holder.learning_hours.setText(String.valueOf(learningLeaderModelData.get(position).getHours()));
        holder.learning_country.setText(learningLeaderModelData.get(position).getCountry());

    }

    @Override
    public int getItemCount() {

        return learningLeaderModelData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
      final TextView learning_name, learning_hours, learning_country;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            learning_name = itemView.findViewById(R.id.learner_name);
            learning_hours = itemView.findViewById(R.id.learning_hours);
            learning_country = itemView.findViewById(R.id.learning_country);

        }
    }

}
