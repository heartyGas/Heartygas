package com.heartygas;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                    Toast.makeText(getApplicationContext(), "Field(s) cannot be empty", Toast.LENGTH_LONG).show();
                } else if (loginEmailTextFieldEdit.getText().toString().equals("customer") && loginPasswordTextFieldEdit.getText().toString().equals("1234")){
                    Intent intent = new Intent(LoginActivity.this, CustomerHomeActivity.class);
                    startActivity(intent);
                } else if (loginEmailTextFieldEdit.getText().toString().equals("vendor") && loginPasswordTextFieldEdit.getText().toString().equals("1234")){
                    Intent intent = new Intent(LoginActivity.this, VendorHomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill in the right details", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Do you want to Exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Oh No!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
