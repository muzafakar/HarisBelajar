package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

public class Guru {

    @SerializedName("jk")
    private String jk;

    @SerializedName("wali_kelas")
    private String waliKelas;

    @SerializedName("no_hp")
    private String noHp;

    @SerializedName("level")
    private String level;

    @SerializedName("npsn")
    private String npsn;

    @SerializedName("mapel")
    private String mapel;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("password")
    private String password;

    @SerializedName("nama")
    private String nama;

    @SerializedName("nip")
    private String nip;

    @SerializedName("foto")
    private String foto;

    @SerializedName("id")
    private String id;

    @SerializedName("id_pengguna")
    private String idPengguna;

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getJk() {
        return jk;
    }

    public void setWaliKelas(String waliKelas) {
        this.waliKelas = waliKelas;
    }

    public String getWaliKelas() {
        return waliKelas;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getNpsn() {
        return npsn;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getMapel() {
        return mapel;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIdPengguna(String idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getIdPengguna() {
        return idPengguna;
    }

    @Override
    public String toString() {
        return
                "Guru{" +
                        "jk = '" + jk + '\'' +
                        ",wali_kelas = '" + waliKelas + '\'' +
                        ",no_hp = '" + noHp + '\'' +
                        ",level = '" + level + '\'' +
                        ",npsn = '" + npsn + '\'' +
                        ",mapel = '" + mapel + '\'' +
                        ",alamat = '" + alamat + '\'' +
                        ",password = '" + password + '\'' +
                        ",nama = '" + nama + '\'' +
                        ",nip = '" + nip + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",id = '" + id + '\'' +
                        ",id_pengguna = '" + idPengguna + '\'' +
                        "}";
    }
}