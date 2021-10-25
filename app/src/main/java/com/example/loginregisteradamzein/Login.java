package com.example.loginregisteradamzein;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button login, register;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.edt_usernameLogin);
        password = (EditText) findViewById(R.id.edt_passwordLogin);
        login = (Button) findViewById(R.id.btn_loginLogin);
        register = (Button) findViewById(R.id.btn_registerLogin);
        progressDialog = new ProgressDialog(Login.this);
        Bundle extras1 = getIntent().getExtras();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stUsername, stEmail, stPassword;
                String sUsername = username.getText().toString();
                String sPassword = password.getText().toString();

                if (getIntent().getExtras() == null) {
                    stUsername = "admin";
                    stEmail = "admin@gmail.com";
                    stPassword = "1234";
                } else {
                    stUsername = extras1.getString("username");
                    stEmail = extras1.getString("email");
                    stPassword = extras1.getString("password");
                }

                if (sUsername.equals(stUsername) && sPassword.equals(stPassword)){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(Login.this, Home.class);
                    int LAUNCH_SECOND_ACTIVITY = 1;
                    homeIntent.putExtra("username", stUsername);
                    homeIntent.putExtra("email", stEmail);
                    homeIntent.putExtra("password", stPassword);
                    startActivityForResult(homeIntent, LAUNCH_SECOND_ACTIVITY);
                }else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}