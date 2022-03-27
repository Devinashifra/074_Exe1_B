package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;

    EditText ednama, edpass;

    String nama, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.button);

        edpass = findViewById(R.id.editTextTextPersonName3);

        ednama = findViewById(R.id.editTextTextPersonName2);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = ednama.getText().toString();

                pass = edpass.getText().toString();

                String email = "Devina";

                //mengeset password yang benar
                String password = "123";

                //mengecek apakah edittext email dan password terdapat isi atau tidak
                if (email.isEmpty() || password.isEmpty()) {
                    //membuat variabel toast dan menampilkan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password wajib diisi", Toast.LENGTH_LONG);
                    //menampilkan variabel
                    t.show();
                }
                else {

                    //mengecek apakah isi dari email dan password sudah sama dengan email dan
                    //password yang sudah diset
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "Login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());

                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(),ActivityHasil.class);

                        i.putExtras(b);

                        startActivity(i);
                    }else {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);

                        t.show();
                    }
                }

            }
        });
    }
}