package com.example.aplikasimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    TextView hasilEmail, hasilPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        hasilEmail = findViewById(R.id.hEmail);
        hasilPass = findViewById(R.id.hPass);

        Bundle b =  getIntent().getExtras();

        String email = b.getString("email");
        String pass = b.getString("pass");

        hasilEmail.setText(email);
        hasilPass.setText(pass);

    }
}