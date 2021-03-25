package com.example.greenhouseadmin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdminModel {

    @Expose()
    @SerializedName("l_name")
    private String l_name;

    @Expose()
    @SerializedName("f_name")
    private String f_name;

    @Expose()
    @SerializedName("username")
    private String username;

    @Expose()
    @SerializedName("password")
    private String password;

    @Expose()
    @SerializedName("success")
    private boolean success;

    @Expose()
    @SerializedName("message")
    private String message;

    public AdminModel() {

    }

    public AdminModel(String l_name, String f_name, String username, String password, boolean success, String message) {
        this.l_name = l_name;
        this.f_name = f_name;
        this.username = username;
        this.password = password;
        this.success = success;
        this.message = message;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
