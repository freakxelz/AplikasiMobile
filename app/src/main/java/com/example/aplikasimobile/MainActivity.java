package com.example.aplikasimobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    Button btnSignIn;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] user = getResources().
                getStringArray(R.array.emailUser);
        final String[] pass = getResources().
                getStringArray(R.array.passUser);

        btnSignIn = findViewById(R.id.btnSigIn);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                String myUsername = edEmail.getText().toString();
                String myPassword = edPassword.getText().toString();

                if (myUsername.isEmpty() || myPassword.isEmpty()){

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password harus diisi!",
                            Toast.LENGTH_LONG);

                    t.show();
                }else {
                    for (int i = 0; i < user.length; i++) {
                        if (user[i].equals(myUsername) &&
                                pass[i].equals(myPassword)) {
                            Toast.makeText(MainActivity.this,
                                    "Login Berhasil",
                                    Toast.LENGTH_LONG).show();
                            found = true;

                            Bundle b = new Bundle();
                            b.putString("email", myUsername.trim());
                            b.putString("pass", myPassword.trim());

                            Intent in = new Intent(getApplicationContext(),
                                    ProfileActivity.class);

                            in .putExtras(b);

                            startActivity(in);

                            break;
                        }
                    }

                    if (!found) {
                        Toast.makeText(MainActivity.this,
                                "Email atau Password Salah",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}