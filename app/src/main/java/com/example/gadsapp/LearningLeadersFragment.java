package com.example.gadsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private APIInterface mAPIInterface;
    private List<LearningLeadersModelData> learningLeaderModelData;
    private LearningLeadersAdapter adapter;


    View view;

    // Required empty constructor
    public LearningLeadersFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.learning_leaders_recyclerView);
        progressBar.setVisibility(View.GONE);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        mAPIInterface = APIClient.getApiClient().create(APIInterface.class);

        Call<List<LearningLeadersModelData>> call = mAPIInterface.getLearningLeaders();

        call.enqueue(new Callback<List<LearningLeadersModelData>>() {

            @Override
            public void onResponse(Call<List<LearningLeadersModelData>> call, Response<List<LearningLeadersModelData>> response) {
                learningLeaderModelData = response.body();
                adapter = new LearningLeadersAdapter(getContext(), learningLeaderModelData);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LearningLeadersModelData>> call, Throwable t) {

            }
        });
        return view;

    }

}
