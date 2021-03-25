package com.example.greenhouseadmin;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greenhouseadmin.Model.GreenhouseModel;
import com.example.greenhouseadmin.Retrofit.ApiClient2;
import com.example.greenhouseadmin.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    EditText name,price,greenhouse,address,phone,img_url;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        apiInterface = ApiClient2.getApiClient().create(ApiInterface.class);

        name = (EditText) findViewById(R.id.productItem);
        price = (EditText) findViewById(R.id.priceItem);
        greenhouse = (EditText) findViewById(R.id.greenhouse);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        img_url = (EditText) findViewById(R.id.productimg);



    }

    public void registerGreenHouse(View v)
    {
        Call<GreenhouseModel> registerGreenHouseCall = apiInterface.registerGreenhouse(
                                                                name.getText().toString(),
                                                                price.getText().toString(),
                                                                greenhouse.getText().toString(),
                                                                address.getText().toString(),
                                                                phone.getText().toString(),
                                                                img_url.getText().toString()
                                                        );
        registerGreenHouseCall.enqueue(new Callback<GreenhouseModel>() {
            @Override
            public void onResponse(Call<GreenhouseModel> call, Response<GreenhouseModel> response) {
                if(response.isSuccessful() && response.body() != null)
                {
                    GreenhouseModel greenhouse = response.body();
                    Toast.makeText(Registration.this, " " + greenhouse.getMessage(), Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(Registration.this, "Failed to insert Greenhouse ", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GreenhouseModel> call, Throwable t) {
                Toast.makeText(Registration.this, " Failed to connect", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
