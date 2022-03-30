package com.errimyhatim.quizapp_m21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText reEmail, rePassword,rePassword2;
    Button bRegister;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reEmail = (EditText) findViewById(R.id.reEmail);
        rePassword = (EditText) findViewById(R.id.rePassword);
        rePassword2 = (EditText) findViewById(R.id.rePassword2);
        bRegister= (Button) findViewById(R.id.bRegister);
        mAuth = FirebaseAuth.getInstance();



        bRegister.setOnClickListener(view -> {

            //step 4 traitement
            createUser();

           /* @Override
            public void onClick(View view) {
                if (reEmail.getText().toString().equals("toto")
                        && rePassword.getText().toString().equals(rePassword2.getText().toString())){
                    startActivity(new Intent(Register.this,QuizActivity.class));
                }
                else{
                    //comme alert
                    Toast.makeText(getApplicationContext(),"Login or Password incorrect",Toast.LENGTH_SHORT);
                }

            }*/
        });



    }
    private void createUser(){
        String email= reEmail.getText().toString();
        String password= rePassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            reEmail.setError("Email cannot be empty");
            reEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)) {
            rePassword.setError("Password cannot be empty");
            rePassword.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, MainActivity.class));
                    }else{
                        Toast.makeText(Register.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}