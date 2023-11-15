package com.example.driveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Log.d("SplashScreen", "onCreate");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("SplashScreen", "Starting LoginScreen activity");
                    startActivity(new Intent(SplashScreen.this, LoginScreen.class));
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 4000);
    }
}
