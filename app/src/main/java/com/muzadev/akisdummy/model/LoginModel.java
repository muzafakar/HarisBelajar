package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {

    @SerializedName("data")
    private List<Guru> data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public void setData(List<Guru> data) {
        this.data = data;
    }

    public List<Guru> getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}