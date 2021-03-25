package com.example.greenhouseadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greenhouseadmin.Model.GreenhouseModel;
import com.example.greenhouseadmin.Retrofit.ApiClient2;
import com.example.greenhouseadmin.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchGreenhouse extends AppCompatActivity {

    EditText name;
    TextView phone, address;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_greenhouse);
        apiInterface = ApiClient2.getApiClient().create(ApiInterface.class);
        name = (EditText) findViewById(R.id.greenhouseName);
        phone = (TextView) findViewById(R.id.greenhousephone);
        address = (TextView) findViewById(R.id.greenhouseaddress);
    }



    public void searchGreenhouse(View v)
    {
            Call<GreenhouseModel> getGreenhousecall = apiInterface.getGreenhouse(name.getText().toString());
            getGreenhousecall.enqueue(new Callback<GreenhouseModel>() {
                @Override
                public void onResponse(Call<GreenhouseModel> call, Response<GreenhouseModel> response) {
                    if(response.isSuccessful() && response.body() != null)
                    {
                        GreenhouseModel greenhouse = response.body();
                        Toast.makeText(SearchGreenhouse.this, " " + greenhouse.getMessage(), Toast.LENGTH_SHORT).show();

                        phone.setText(greenhouse.getPhone());
                        address.setText(greenhouse.getAddress());
                    }
                }

                @Override
                public void onFailure(Call<GreenhouseModel> call, Throwable t) {
                    Toast.makeText(SearchGreenhouse.this, "No record found", Toast.LENGTH_SHORT).show();
                }
            });
    }
}