package com.example.myflipapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent startActivity = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(startActivity);
                finish();

            }
        };
        handler.postDelayed(runnable , 3000);
    }
}