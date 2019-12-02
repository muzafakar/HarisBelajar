package com.muzadev.akisdummy.network;

import com.muzadev.akisdummy.model.KelasResponse;
import com.muzadev.akisdummy.model.NilaiResponse;
import com.muzadev.akisdummy.model.SiswaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiSiswa {
    @GET("view_data_kelas_jurusan.php")
    Call<KelasResponse> getAllKelas(
            @Query("npsn") String npsn,
            @Query("pass") String password
    );

    @GET("getData_siswa_perkelas.php")
    Call<SiswaResponse> getSiswaPerkelas(
            @Query("id_kelas") String idKelas,
            @Query("pass") String password
    );

    @GET("getKelas.php")
    Call<NilaiResponse> getMyClass(
            @Query("id_guru") String idKelas,
            @Query("pass") String password
    );


}
