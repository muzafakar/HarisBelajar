package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SiswaResponse {
    @SerializedName("siswa")
    private List<Siswa> siswaList;

    public List<Siswa> getSiswaList() {
        return siswaList;
    }

    public void setSiswaList(List<Siswa> siswaList) {
        this.siswaList = siswaList;
    }
}
