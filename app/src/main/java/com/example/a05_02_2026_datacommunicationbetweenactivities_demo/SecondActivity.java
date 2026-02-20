package com.example.a05_02_2026_datacommunicationbetweenactivities_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtUsername;
    EditText edtEmail;
    Button btnBack;
    String extractedUsername,extractedBatchName;
    int batchId, rollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        txtUsername = findViewById(R.id.txtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        btnBack = findViewById(R.id.btnBack);
        getDataFromIntent();
    }

    private void getDataFromIntent(){
        Intent i = getIntent();
        extractedUsername = i.getStringExtra("username");
        rollNumber = i.getIntExtra("roll_number",-1);
        batchId = i.getIntExtra("batch_id", -1);
        extractedBatchName = i.getStringExtra("batch_name");

        txtUsername.setText(extractedUsername);
    }
}
