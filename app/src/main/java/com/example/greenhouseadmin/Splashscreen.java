package com.example.greenhouseadmin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME = 5500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler().postDelayed(new Runnable(){
            public void run()
            {
                Intent homeIntent = new Intent(Splashscreen.this, HomeScreen.class );
                startActivity(homeIntent);
                finish();

            }



        }, SPLASH_SCREEN_TIME);
    }
}