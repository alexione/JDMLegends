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

public class LoginActiv  extends AppCompatActivity {

    public TextInputEditText LoginEmail;
    public TextInputEditText LoginPassword;
    public TextView RegisterHere;
    public Button buttonLogin;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_login);

        LoginEmail = findViewById(R.id.LoginEmail);
        LoginPassword = findViewById(R.id.LoginPass);
        RegisterHere = findViewById(R.id.RegisterHere);
        buttonLogin = findViewById(R.id.buttonLogin);

        mAuth = FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(view -> loginUser());
        RegisterHere.setOnClickListener(view -> startActivity(new Intent(LoginActiv.this, RegisterActiv.class)));

    }

    private void loginUser() {
        String email = Objects.requireNonNull(LoginEmail.getText()).toString();
        String password = Objects.requireNonNull(LoginPassword.getText()).toString();

        if (TextUtils.isEmpty(email)) {
            LoginEmail.setError("Email cannot be empty");
            LoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            LoginPassword.setError("Password cannot be empty");
            LoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActiv.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActiv.this, Main2Activity.class));
                }
            });
        }
    }

}
