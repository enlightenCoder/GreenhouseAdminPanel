package com.example.greenhouseadmin.Retrofit;

import com.example.greenhouseadmin.Model.AdminModel;
import com.example.greenhouseadmin.Model.GreenhouseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface
{
    @FormUrlEncoded
    @POST("loginuser.php")
    Call<AdminModel> loginUser(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("registerGreenhouse.php")
    Call<GreenhouseModel> registerGreenhouse(@Field("name") String productName,
                                             @Field("price") String price,
                                             @Field("greenhouse") String greenhouse,
                                             @Field("address") String address,
                                             @Field("phone") String phone,
                                             @Field("image_url") String img_url );


    @GET("searchGreenhouse.php")
    Call<GreenhouseModel>   getGreenhouse(@Query("name") String name);


    @FormUrlEncoded
    @POST("updateGreenhouse.php")
    Call<GreenhouseModel> updateGreenhouse(@Field("name") String name,
                                           @Field("new_name") String greenhouse,
                                           @Field("address") String address,
                                           @Field("phone") String phone
                                           );


    @FormUrlEncoded
    @POST("deleteGreenhouse.php")
    Call<GreenhouseModel> deleteGreenhouse(@Field("name") String name);


}
