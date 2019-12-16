package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

public class Siswa {

    @SerializedName("jk")
    private String jk;

    @SerializedName("nisn")
    private String nisn;

    @SerializedName("nama_lengkap")
    private String namaLengkap;

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getJk() {
        return jk;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }
}