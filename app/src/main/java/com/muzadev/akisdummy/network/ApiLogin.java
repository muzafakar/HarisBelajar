package com.muzadev.akisdummy.network;

import com.muzadev.akisdummy.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiLogin {
    @FormUrlEncoded
    @POST("loginGuru.php")
    Call<LoginModel> loginGuru(
            @Field("no_hp") String noHp,
            @Field("password") String password
    );
}
