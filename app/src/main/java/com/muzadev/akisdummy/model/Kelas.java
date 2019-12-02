package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

public class Kelas implements Comparable<Kelas> {

    @SerializedName("id_kelas_jurusan")
    private String idKelasJurusan;

    @SerializedName("nama")
    private String nama;

    @SerializedName("jumlah")
    private String jumlah;

    @SerializedName("npsn")
    private String npsn;

    @SerializedName("id_wali_kelas")
    private String idWaliKelas;

    public void setIdKelasJurusan(String idKelasJurusan) {
        this.idKelasJurusan = idKelasJurusan;
    }

    public String getIdKelasJurusan() {
        return idKelasJurusan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getNpsn() {
        return npsn;
    }

    public void setIdWaliKelas(String idWaliKelas) {
        this.idWaliKelas = idWaliKelas;
    }

    public String getIdWaliKelas() {
        return idWaliKelas;
    }

    @Override
    public int compareTo(Kelas o) {
        return o.idKelasJurusan.compareTo(idKelasJurusan);
    }
}