package com.example.mobilesoftwareengineeringlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Main extends AppCompatActivity {

    private Button clickMe;
    private EditText inputUsername;
    private EditText inputPassword;
    private String usernameString;
    private String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        clickMe = findViewById(R.id.login_btn);

        inputUsername = findViewById(R.id.username_field);
        inputPassword = findViewById(R.id.password_field);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usernameString = inputUsername.getText().toString();
                passwordString = inputPassword.getText().toString();

                if(!usernameString.equalsIgnoreCase("Admin") && !passwordString.equalsIgnoreCase("Password")){
                    Toast.makeText(getApplicationContext(), "Wrong Username and Password", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(view.getContext(), Details.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", "admin");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}