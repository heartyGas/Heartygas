package com.heartygas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.heartygas.ui.main.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    TextView userRegisterTextClick;
    Button loginToHomeActivityClick;
    EditText loginEmailTextFieldEdit, loginPasswordTextFieldEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmailTextFieldEdit = findViewById(R.id.loginEmailTextField);
        loginPasswordTextFieldEdit = findViewById(R.id.loginPasswordTextField);

        userRegisterTextClick = findViewById(R.id.userRegisterText);
        userRegisterTextClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginToHomeActivityClick = findViewById(R.id.loginToHomeActivity);
        loginToHomeActivityClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginEmailTextFieldEdit.getText().toString().isEmpty() || loginPasswordTextFieldEdit.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill in the details", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
