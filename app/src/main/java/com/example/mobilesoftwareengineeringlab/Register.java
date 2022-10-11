package com.example.mobilesoftwareengineeringlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button registerBtn;
    private EditText inputUsername;
    private EditText inputPassword;
    private String usernameString;
    private String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.register_btn);

        inputUsername = findViewById(R.id.username_field);
        inputPassword = findViewById(R.id.password_field);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usernameString = inputUsername.getText().toString();
                passwordString = inputPassword.getText().toString();

                if(!usernameString.equalsIgnoreCase("") && !passwordString.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Please enter a Username and Password!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}