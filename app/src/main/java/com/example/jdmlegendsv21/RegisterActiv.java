package com.example.jdmlegendsv21;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterActiv extends AppCompatActivity {

    TextInputEditText RegEmail;
    TextInputEditText RegPassword;
    TextView LoginHere;
    Button buttonRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_signup);

        RegEmail = findViewById(R.id.LoginEmail);
        RegPassword = findViewById(R.id.LoginPass);
        LoginHere = findViewById(R.id.RegisterHere);
        buttonRegister = findViewById(R.id.buttonLogin);

        mAuth = FirebaseAuth.getInstance();

        buttonRegister.setOnClickListener(view -> createUser());

        LoginHere.setOnClickListener(view -> startActivity(new Intent(RegisterActiv.this, LoginActiv.class)));
    }

    private void createUser(){
        String email = Objects.requireNonNull(RegEmail.getText()).toString();
        String password = Objects.requireNonNull(RegPassword.getText()).toString();

        if (TextUtils.isEmpty(email)){
            RegEmail.setError("Email cannot be empty");
            RegEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)){
            RegPassword.setError("Password cannot be empty");
            RegPassword.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActiv.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActiv.this, LoginActiv.class));
                } else {
                    Toast.makeText(RegisterActiv.this,
                            "Login Error: " + Objects.requireNonNull(task.getException()).getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

