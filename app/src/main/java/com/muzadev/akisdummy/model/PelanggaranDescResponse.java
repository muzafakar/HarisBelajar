package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PelanggaranDescResponse {

    @SerializedName("detail_kategori")
    private List<DetailPelanggaranItem> detailKategori;

    public List<DetailPelanggaranItem> getDetailKategori() {
        return detailKategori;
    }
}