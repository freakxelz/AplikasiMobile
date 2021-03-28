package com.example.aplikasimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {
    EditText nama, email, alamat, pass, konfPass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nama = findViewById(R.id.daftarNama);
        email = findViewById(R.id.daftarEmail);
        alamat = findViewById(R.id.daftarAlamat);
        pass = findViewById(R.id.daftarPass);
        konfPass = findViewById(R.id.daftarKonfPass);
        fab = findViewById(R.id.btnSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nama.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        pass.getText().toString().isEmpty() ||
                        konfPass.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "SEMUA DATA HARUS DIISI!",
                            Snackbar.LENGTH_LONG).show();
                }
                else {
                    if(pass.getText().toString().equals(konfPass.getText().toString())){
                        Toast.makeText(SignUpActivity.this,
                                "Pendaftaran Berhasil!",
                                Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Snackbar.make(view, "PASSWORD DAN KONFIRMASI PASSWORD HARUS SAMA!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}