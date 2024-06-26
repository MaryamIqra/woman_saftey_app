package com.example.womansafteyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class homeactivity extends AppCompatActivity {

    Button safety_tips, alarm;
    Button showMap;
    TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        alarm = findViewById(R.id.user_2);
        safety_tips = findViewById(R.id.user_4);
        showMap = findViewById(R.id.user_6);
        usernameTextView = findViewById(R.id.UserN_account);



        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.beep);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        // Assume the username is passed from the previous activity as "username"
        String username = getIntent().getStringExtra("username");
        usernameTextView.setText(username);

        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeactivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        safety_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start safety_tips activity when safety_tips button is clicked
                startActivity(new Intent(homeactivity.this, safety_tips.class));
            }
        });


        EdgeToEdge.enable(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewh);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_select_guardian) {
                startActivity(new Intent(getApplicationContext(), chat_guardian.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_select_contact) {
                startActivity(new Intent(getApplicationContext(), trusted_contact.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), user_profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }
}
