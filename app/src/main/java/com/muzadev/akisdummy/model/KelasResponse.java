package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KelasResponse {
    @SerializedName("data_siswa_perkelas")
    private List<Kelas> listKelas;

    public List<Kelas> getListKelas() {
        return listKelas;
    }

    public void setListKelas(List<Kelas> listKelas) {
        this.listKelas = listKelas;
    }
}
