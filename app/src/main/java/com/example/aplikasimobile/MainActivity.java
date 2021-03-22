package com.example.aplikasimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] user = getResources().getStringArray(R.array.emailUser);
        final String[] pass = getResources().getStringArray(R.array.passUser);

        btnSignIn = findViewById(R.id.btnSigIn);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                String myUsername = edEmail.getText().toString();
                String myPassword = edPassword.getText().toString();

                for (int i = 0; i < user.length; i++) {
                    if (user[i].equals(myUsername) && pass[i].equals(myPassword)) {
                        Toast.makeText(MainActivity.this,"Login Berhasil",Toast.LENGTH_LONG).show();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    Toast.makeText(MainActivity.this,"Email atau Password Salah",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}