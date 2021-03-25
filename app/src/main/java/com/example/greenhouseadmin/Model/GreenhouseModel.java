package com.example.greenhouseadmin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GreenhouseModel
{

    @Expose()
    @SerializedName("name")
    private String name;

    @Expose()
    @SerializedName("price")
    private String price;

    @Expose()
    @SerializedName("greenhouse")
    private String greenhouse;

    @Expose()
    @SerializedName("address")
    private String address;

    @Expose()
    @SerializedName("phone")
    private String phone;

    @Expose()
    @SerializedName("image_url")
    private String image_url;

    @Expose()
    @SerializedName("success")
    private boolean success;

    @Expose()
    @SerializedName("message")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(String greenhouse) {
        this.greenhouse = greenhouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
