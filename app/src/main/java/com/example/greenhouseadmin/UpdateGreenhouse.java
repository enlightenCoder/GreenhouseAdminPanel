package com.example.greenhouseadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greenhouseadmin.Model.GreenhouseModel;
import com.example.greenhouseadmin.Retrofit.ApiClient2;
import com.example.greenhouseadmin.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateGreenhouse extends AppCompatActivity {

    EditText greenhouseName,greenhouse,address,phone;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_greenhouse);

        apiInterface = ApiClient2.getApiClient().create(ApiInterface.class);
        greenhouseName = (EditText) findViewById(R.id.gname);
        greenhouse = (EditText) findViewById(R.id.greenhouse);
        address = (EditText) findViewById(R.id.address_);
        phone = (EditText) findViewById(R.id.phone_);
    }


    public void searchGreen(View v)
    {

            Call<GreenhouseModel> getGreenhousecall_ = apiInterface.getGreenhouse(greenhouseName.getText().toString());
            getGreenhousecall_.enqueue(new Callback<GreenhouseModel>() {
                @Override
                public void onResponse(Call<GreenhouseModel> call, Response<GreenhouseModel> response) {
                    if(response.isSuccessful() && response.body() != null)
                    {
                        GreenhouseModel greenhouse_ = response.body();
                        Toast.makeText(UpdateGreenhouse.this, " " + greenhouse_.getMessage(), Toast.LENGTH_SHORT).show();
                        greenhouse.setText(greenhouse_.getGreenhouse());
                        address.setText(greenhouse_.getAddress());
                        phone.setText(greenhouse_.getPhone());

                    }
                }

                @Override
                public void onFailure(Call<GreenhouseModel> call, Throwable t) {
                    Toast.makeText(UpdateGreenhouse.this, "No record found !!!!", Toast.LENGTH_SHORT).show();
                }
            });
    }



    public void updateGreen(View v)
    {
        Call<GreenhouseModel> updateCall = apiInterface.updateGreenhouse(
                                                greenhouseName.getText().toString(),
                                                greenhouse.getText().toString(),
                                                address.getText().toString(),
                                                phone.getText().toString()

                                                    );
        updateCall.enqueue(new Callback<GreenhouseModel>() {
            @Override
            public void onResponse(Call<GreenhouseModel> call, Response<GreenhouseModel> response) {
                if(response.isSuccessful() && response.body() != null)
                {
                    GreenhouseModel model = response.body();
                    Toast.makeText(UpdateGreenhouse.this, " "+ model.getMessage() , Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(UpdateGreenhouse.this, "Some error occured " , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GreenhouseModel> call, Throwable t) {
                Toast.makeText(UpdateGreenhouse.this, " Failed to update" , Toast.LENGTH_SHORT).show();

            }
        });
    }



}