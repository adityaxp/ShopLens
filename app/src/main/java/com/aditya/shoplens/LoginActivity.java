package com.aditya.shoplens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    TextView signUpTextView;
    EditText emailEditText;
    TextInputLayout passwordTextInputLayout;
    Button logInButton;
    private FirebaseAuth mAuth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpTextView = (TextView) findViewById(R.id.signUpTextView);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordEditText);
        logInButton = (Button) findViewById(R.id.loginButton);
        mAuth = FirebaseAuth.getInstance();


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailEditText.getText().toString().equals("") || passwordTextInputLayout.getEditText().getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Fields can't be empty!", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(emailEditText.getText().toString().trim(), passwordTextInputLayout.getEditText().getText().toString().trim())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Authentication Successful!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        
        
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });





    }
}