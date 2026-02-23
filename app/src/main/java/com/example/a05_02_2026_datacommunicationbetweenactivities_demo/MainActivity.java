package com.example.a05_02_2026_datacommunicationbetweenactivities_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtEmail;
    EditText edtUsername;
    Button btnSubmit;
    String city, bloodGroup, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new BtnSubmitClickListener());
    }

    public class BtnSubmitClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("username",edtUsername.getText().toString());
            intent.putExtra("roll_number",1232);
            intent.putExtra("batch_id",89);
            intent.putExtra("batch_name","Android Feb 2026 Batch");
//          startActivity(intent);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            Bundle bundle = data.getExtras();
            assert bundle != null;
            city = bundle.getString("city");
            bloodGroup = bundle.getString("blood_group");
            email = bundle.getString("email");

            txtEmail.setText(email);
        }
    }
}