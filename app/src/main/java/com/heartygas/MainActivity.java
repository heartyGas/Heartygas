package com.heartygas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hertlybutton;

    public static int SPLASH_TIME_OUT = 5000;
//    public static String sss = "Heart";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT
        );

        hertlybutton = findViewById(R.id.heart);

        hertlybutton.setOnClickListener(v -> {
            Intent dd = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(dd);
        });


    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }
}


