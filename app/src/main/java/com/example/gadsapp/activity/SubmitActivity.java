package com.example.gadsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gadsapp.R;
import com.example.gadsapp.api.SubmitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubmitActivity extends AppCompatActivity {
    private Button button, yesButton;
    private EditText firstNameInput, lastNameInput, emailInput, projectLinkInput;
    Dialog customDialog, successDialog;
    private ImageView imageView, backArrow;
    private int width, height;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Toolbar toolbar = findViewById(R.id.submit_toolBar);
        button = findViewById(R.id.submit_button);
        yesButton = findViewById(R.id.yes_button);
        backArrow = findViewById(R.id.arrow_back);
        imageView = findViewById(R.id.cancel_icon);
        firstNameInput = findViewById(R.id.edit_firstName);
        lastNameInput = findViewById(R.id.edit_lastName);
        emailInput = findViewById(R.id.edit_email_address);
        projectLinkInput = findViewById(R.id.edit_projectLink);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubmitActivity.this, LearningLeadersActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);



        customDialog = new Dialog(this);
        successDialog = new Dialog(this);

        Retrofit retrofitSubmit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();

        final SubmitInterface googleForms = retrofitSubmit.create(SubmitInterface.class);
        button.setOnClickListener(view -> {
            if ( firstNameInput.getText().toString().isEmpty() || lastNameInput.getText().toString().isEmpty() ||
            emailInput.getText().toString().isEmpty() || projectLinkInput.getText().toString().isEmpty()){
                Toast.makeText(SubmitActivity.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
            } else {
                customDialog.setContentView(R.layout.custom_are_you_sure);
                imageView = customDialog.findViewById(R.id.cancel_icon);
                yesButton = customDialog.findViewById(R.id.yes_button);

                imageView.setOnClickListener(view1 -> customDialog.dismiss());

                customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                customDialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
                customDialog.show();

                yesButton.setOnClickListener(view12 ->{
                    String email = emailInput.getText().toString();
                    String firstName = firstNameInput.getText().toString();
                    String lastName = lastNameInput.getText().toString();
                    String link = projectLinkInput.getText().toString();

                    Call<Void> completeGoogleForms = googleForms.completeGoogleForm(email, firstName, lastName, link);
                    completeGoogleForms.enqueue(callBack);

                });

            }
        });


    }

    private final Callback<Void> callBack = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            Log.d("RESPONSE", String.valueOf(response.code()));
            successDialog.setContentView(R.layout.custom_submission_successful);
            successDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            successDialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
            successDialog.show();
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            successDialog.setContentView(R.layout.custom_not_successful);
            successDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            successDialog.getWindow().setLayout((6 * width)/7, (4 * height)/5);
            successDialog.show();

            handler = new Handler();
            handler.postDelayed(() -> {
                successDialog.cancel();
                successDialog.dismiss();
                customDialog.dismiss();
            }, 1000);

        }
    };
}