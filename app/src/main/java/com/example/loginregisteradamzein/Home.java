package com.example.loginregisteradamzein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView username, email, password;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras1 = getIntent().getExtras();
        String stUsername = extras1.getString("username");
        String stEmail = extras1.getString("email");
        String stPassword = extras1.getString("password");
        username = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        logout = (Button) findViewById(R.id.btn_logout);
        username.setText(stUsername);
        email.setText(stEmail);
        password.setText(stPassword);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Logout Success", Toast.LENGTH_SHORT).show();
                Intent logoutIntent = new Intent(Home.this, Login.class);
                startActivity(logoutIntent);
            }
        });
    }
}