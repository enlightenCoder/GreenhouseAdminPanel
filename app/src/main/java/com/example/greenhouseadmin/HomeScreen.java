package com.example.greenhouseadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    Button registerGreenhouse,searchGreenhouse,updateGreenhouse,deleteGreenhouse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        registerGreenhouse = (Button) findViewById(R.id.registerGreenhouseBtn);
        searchGreenhouse = (Button) findViewById(R.id.searchGreenhouseBtn);
        updateGreenhouse = (Button) findViewById(R.id.updateGreenhouseBtn);
        deleteGreenhouse = (Button) findViewById(R.id.deleteGreenhouseBtn);



    }



    public void registerGreenhouse_(View v)
    {
        Intent intent = new Intent(HomeScreen.this,Registration.class);
        startActivity(intent);
    }

    public void searchGreenhouse(View v)
    {
            Intent intent = new Intent(HomeScreen.this, SearchGreenhouse.class);
            startActivity(intent);
    }

    public void updateGreenhouse(View v)
    {
        Intent intent = new Intent(HomeScreen.this, UpdateGreenhouse.class);
        startActivity(intent);

    }

    public void deleteGreenhouse(View v)
    {
        Intent intent = new Intent(HomeScreen.this, DeleteGreenhouse.class);
        startActivity(intent);
    }





}