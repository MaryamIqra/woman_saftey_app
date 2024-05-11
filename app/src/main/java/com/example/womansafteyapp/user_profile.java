package com.example.womansafteyapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.activity.EdgeToEdge;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class user_profile extends AppCompatActivity {
    private EditText newNameEditText;
    private EditText newPasswordEditText;
    private Button updateNameButton;
    private Button updatePasswordButton;
    private TextView userEmailTextView;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);
        newNameEditText = findViewById(R.id.editText_new_name);
        newPasswordEditText = findViewById(R.id.editText_new_password);
        updateNameButton = findViewById(R.id.button_update_name);
        updatePasswordButton = findViewById(R.id.button_update_password);
            mAuth = FirebaseAuth.getInstance();
            mUser = mAuth.getCurrentUser();
            mDatabase = FirebaseDatabase.getInstance().getReference("users");

            if (mUser != null) {
                userEmailTextView.setText(mUser.getEmail());
            }

            updateNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newName = newNameEditText.getText().toString();
                    if (!newName.isEmpty()) {
                        mDatabase.child(mUser.getUid()).child("name").setValue(newName);
                        Toast.makeText(user_profile.this, "Name updated successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(user_profile.this, "Please enter a new name", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            updatePasswordButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newPassword = newPasswordEditText.getText().toString();
                    if (!newPassword.isEmpty()) {
                        mUser.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(user_profile.this, "Password updated successfully!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(user_profile.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(user_profile.this, "Please enter a new password", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        EdgeToEdge.enable(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.UbottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_profile) {
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
            }else if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), homeactivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
            return false;
        });
    }
}
