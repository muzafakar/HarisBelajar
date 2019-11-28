package com.muzadev.akisdummy.network;

import com.muzadev.akisdummy.model.LoginModel;
import com.muzadev.akisdummy.model.Siswa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiLogin {
    @FormUrlEncoded
    @POST("loginGuru.php")
    Call<LoginModel> loginGuru(
            @Field("no_hp") String noHp,
            @Field("password") String password
    );

    @GET("getSiswa.php")
    Call<Siswa> getSiswa(@Query("npsn") String npsn);
}
