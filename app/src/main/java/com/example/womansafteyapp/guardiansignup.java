package com.example.womansafteyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class guardiansignup extends AppCompatActivity {

    EditText signupgname, signupgEmail, sigupgUsername, signupgPassword;
    Button signup;
    TextView backlogin;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardiansignup);
        signupgname = findViewById(R.id.gs_name);
        signupgEmail = findViewById(R.id.gs_email);
        sigupgUsername = findViewById(R.id.us_gusername);
        signupgPassword = findViewById(R.id.gs_password);
        backlogin = findViewById(R.id.back_login); // Corrected variable name
        signup = findViewById(R.id.button2); // Assigning to signup button


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("guardians");
                String name = signupgname.getText().toString();
                String email = signupgEmail.getText().toString();
                String username = sigupgUsername.getText().toString();
                String password = signupgPassword.getText().toString();

                // Create HelperClassg object with the retrieved guardian information
                HelperClassg helperClass = new HelperClassg(name, email, username, password);

                reference.child(username).setValue(helperClass);

                Toast.makeText(guardiansignup.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(guardiansignup.this, guardianlogin.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for back to login text
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to login activity
                Intent intent = new Intent(guardiansignup.this, guardianlogin.class);
                startActivity(intent);
            }
        });
    }
}