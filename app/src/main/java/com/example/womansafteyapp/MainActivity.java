package com.example.womansafteyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView signUser, signGuardian, signPolice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find TextView views by their IDs
        signUser = findViewById(R.id.sign_user);
        signGuardian = findViewById(R.id.sign_guardian);
        signPolice = findViewById(R.id.sign_police);

        // Check if permissions are granted
        if (!checkPermissions()) {
            // If permissions are not granted, start PermissionsActivity
            Intent intent = new Intent(MainActivity.this, Permissions.class);
            startActivity(intent);
            finish(); // Finish MainActivity so that user cannot go back without granting permissions
        }

        // Set OnClickListener for signUser TextView
        signUser.setOnClickListener(v -> {
            // Start userlogin activity when signUser TextView is clicked
            startActivity(new Intent(MainActivity.this, userlogin.class));
        });

        // Set OnClickListener for signGuardian TextView
        signGuardian.setOnClickListener(v -> {
            // Start guardianlogin activity when signGuardian TextView is clicked
            startActivity(new Intent(MainActivity.this, guardianlogin.class));
        });

        // Set OnClickListener for signPolice TextView
        signPolice.setOnClickListener(v -> {
            // Start policelogin activity when signPolice TextView is clicked
            startActivity(new Intent(MainActivity.this, policelogin.class));
        });
    }

    // Method to check permissions
    private boolean checkPermissions() {
        // Implement your logic to check permissions here
        // Return true if permissions are granted, false otherwise
        return true; // For now, returning true for demonstration purpose
    }
}
