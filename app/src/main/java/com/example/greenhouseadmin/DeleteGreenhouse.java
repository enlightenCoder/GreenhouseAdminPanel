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

public class DeleteGreenhouse extends AppCompatActivity {

    EditText gname_;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_greenhouse);
        apiInterface = ApiClient2.getApiClient().create(ApiInterface.class);
        gname_ = (EditText) findViewById(R.id.gname_);
    }


    public void deleteGreen(View v)
    {
        Call<GreenhouseModel> deleteCall = apiInterface.deleteGreenhouse(gname_.getText().toString());
        deleteCall.enqueue(new Callback<GreenhouseModel>() {
            @Override
            public void onResponse(Call<GreenhouseModel> call, Response<GreenhouseModel> response) {
                if(response.isSuccessful() && response.body() != null)
                {
                    GreenhouseModel model_ = response.body();
                    Toast.makeText(DeleteGreenhouse.this, " " + model_.getMessage(), Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(DeleteGreenhouse.this, " Record not found !", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GreenhouseModel> call, Throwable t) {
                Toast.makeText(DeleteGreenhouse.this, "Record not found ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}