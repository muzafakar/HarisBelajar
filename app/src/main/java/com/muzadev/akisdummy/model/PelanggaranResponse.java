package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PelanggaranResponse {

    @SerializedName("list kategori")
    private List<Pelanggaran> listKategori;

    public List<Pelanggaran> getListKategori() {
        return listKategori;
    }
}