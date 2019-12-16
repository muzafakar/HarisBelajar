package com.muzadev.akisdummy.network;

import com.muzadev.akisdummy.model.PelanggaranDescResponse;
import com.muzadev.akisdummy.model.PelanggaranResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiPelanggaran {
    @GET("getKategoriPelanggaran.php")
    Call<PelanggaranResponse> getPelanggaran(
            @Query("npsn") String npsn,
            @Query("pass") String password
    );

    @GET("getDeskripsiPelanggaran.php")
    Call<PelanggaranDescResponse> getPelanggaranDesc(
            @Query("npsn") String npsn,
            @Query("id_kategori") String idPelangaran,
            @Query("pass") String password
    );
}
