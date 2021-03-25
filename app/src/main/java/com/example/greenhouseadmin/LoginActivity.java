package com.example.greenhouseadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greenhouseadmin.Model.AdminModel;
import com.example.greenhouseadmin.Retrofit.ApiClient;
import com.example.greenhouseadmin.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity
{

    ApiInterface apiInterface;
    EditText username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }


    public void loginUser(View v)
    {
        Call<AdminModel> loginUserCall = apiInterface.loginUser(username.getText().toString(), password.getText().toString());
        loginUserCall.enqueue(new Callback<AdminModel>() {
            @Override
            public void onResponse(Call<AdminModel> call, Response<AdminModel> response) {

                if(response.body() != null)
                {
                    AdminModel admin = response.body();
                    if(admin.isSuccess())
                    {
                        Toast.makeText(LoginActivity.this, " " + admin.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, Splashscreen.class);
                        startActivity(intent);
                        finish();
                    }else{

                        Toast.makeText(LoginActivity.this, " " + admin.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }



            }

            @Override
            public void onFailure(Call<AdminModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "No such Record", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void registerUser(View v)
    {

    }

}