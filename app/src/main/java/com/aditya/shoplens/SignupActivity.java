package com.aditya.shoplens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    Toolbar signUpToolBar;
    EditText userNameEditText, emailEdiText;
    TextInputLayout passwordTextInputLayout;
    Button signUpButton;
    TextView logInTextView;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpToolBar =  findViewById(R.id.signUpToolBar);

        setSupportActionBar(signUpToolBar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        signUpToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        emailEdiText = (EditText) findViewById(R.id.emailEditText);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordEditText);
        logInTextView = (TextView) findViewById(R.id.logInTextView);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        logInTextView = (TextView) findViewById(R.id.logInTextView);
        mAuth = FirebaseAuth.getInstance();

        logInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userNameEditText.getText().toString().equals("") || emailEdiText.getText().toString().equals("") || passwordTextInputLayout.getEditText().getText().toString().equals("")){
                    Toast.makeText(SignupActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                }else{

                    mAuth.createUserWithEmailAndPassword(emailEdiText.getText().toString(), passwordTextInputLayout.getEditText().getText().toString())
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        SignUpData signUpData = new SignUpData(userNameEditText.getText().toString(), emailEdiText.getText().toString());
                                        FirebaseDatabase.getInstance("https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("User").child(mAuth.getCurrentUser().getUid()).setValue(signUpData).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(SignupActivity.this, "User successfully added", Toast.LENGTH_SHORT).show();
                                                FirebaseAuth.getInstance().signOut();
                                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(SignupActivity.this, "Failed!!!", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                    } else {
                                        Toast.makeText(SignupActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }
            }
        });


    }
}