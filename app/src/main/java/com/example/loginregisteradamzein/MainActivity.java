package com.example.loginregisteradamzein;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, email, password, confPassword;
    Button login, register;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edt_usernameRegister);
        email = (EditText) findViewById(R.id.edt_emailRegister);
        password = (EditText) findViewById(R.id.edt_passwordRegister);
        confPassword= (EditText) findViewById(R.id.edt_confPasswordRegister);
        login = (Button) findViewById(R.id.btn_loginRegister);
        register = (Button) findViewById(R.id.btn_registerRegister);
        progressDialog = new ProgressDialog(MainActivity.this);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUsername = username.getText().toString();
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                String sConfPassword = confPassword.getText().toString();

                if(sPassword.equals(sConfPassword) && !sPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    int LAUNCH_SECOND_ACTIVITY = 1;
                    loginIntent.putExtra("username", sUsername);
                    loginIntent.putExtra("email", sEmail);
                    loginIntent.putExtra("password", sPassword);
                    startActivityForResult(loginIntent, LAUNCH_SECOND_ACTIVITY);
                } else {
                    Toast.makeText(getApplicationContext(), "Fail! passwords don't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}