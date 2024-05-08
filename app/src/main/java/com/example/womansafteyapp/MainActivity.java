package com.example.womansafteyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView signUser, signGuardian, signPolice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find EditText views by their IDs
        signUser = findViewById(R.id.sign_user);
        signGuardian = findViewById(R.id.sign_guardian);
        signPolice = findViewById(R.id.sign_police);

        // Set OnClickListener for signGuardian EditText
        signGuardian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start GuardianActivity when signGuardian EditText is clicked
                startActivity(new Intent(MainActivity.this, guardianlogin.class));
            }
        });

        // Set OnClickListener for signPolice EditText
        signPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PoliceActivity when signPolice EditText is clicked
                startActivity(new Intent(MainActivity.this, policelogin.class));
            }
        });
    }
}