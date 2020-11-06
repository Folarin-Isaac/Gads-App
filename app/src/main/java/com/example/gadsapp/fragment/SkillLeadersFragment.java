package com.example.gadsapp.fragment;

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

import com.example.gadsapp.R;
import com.example.gadsapp.adapter.SkillIQAdapter;
import com.example.gadsapp.model.SkillIQModelData;
import com.example.gadsapp.api.APIClient;
import com.example.gadsapp.api.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillLeadersFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private APIInterface mAPIInterface;
    private SkillIQAdapter skillIQAdapter;
    private List<SkillIQModelData> skillIQModelData;

    View view;
    public SkillLeadersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_skill_leaders, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.skilliq_leaders_recyclerView);
        progressBar.setVisibility(View.GONE);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAPIInterface = APIClient.getApiClient().create(APIInterface.class);

        Call<List<SkillIQModelData>> call = mAPIInterface.getSkillIqLeaders();

        call.enqueue(new Callback<List<SkillIQModelData>>() {
            @Override
            public void onResponse(Call<List<SkillIQModelData>> call, Response<List<SkillIQModelData>> response) {
                skillIQModelData = response.body();
                skillIQAdapter = new SkillIQAdapter(getContext(), skillIQModelData);
                recyclerView.setAdapter(skillIQAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillIQModelData>> call, Throwable t) {

            }
        });
        return view;

    }
}
