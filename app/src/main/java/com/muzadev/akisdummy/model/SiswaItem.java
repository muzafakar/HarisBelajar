package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

public class SiswaItem{

	@SerializedName("jk")
	private String jk;

	@SerializedName("foto_siswa")
	private String fotoSiswa;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("nisn")
	private String nisn;

	@SerializedName("tmpt_lahir")
	private String tmptLahir;

	@SerializedName("agama")
	private String agama;

	@SerializedName("npsn")
	private String npsn;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("tggl_lahir")
	private String tgglLahir;

	@SerializedName("password")
	private String password;

	@SerializedName("name")
	private String name;

	@SerializedName("nama_sekolah")
	private String namaSekolah;

	@SerializedName("nis")
	private String nis;

	@SerializedName("id")
	private String id;

	@SerializedName("kelas_saat_ini")
	private String kelasSaatIni;

	public void setJk(String jk){
		this.jk = jk;
	}

	public String getJk(){
		return jk;
	}

	public void setFotoSiswa(String fotoSiswa){
		this.fotoSiswa = fotoSiswa;
	}

	public String getFotoSiswa(){
		return fotoSiswa;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setNisn(String nisn){
		this.nisn = nisn;
	}

	public String getNisn(){
		return nisn;
	}

	public void setTmptLahir(String tmptLahir){
		this.tmptLahir = tmptLahir;
	}

	public String getTmptLahir(){
		return tmptLahir;
	}

	public void setAgama(String agama){
		this.agama = agama;
	}

	public String getAgama(){
		return agama;
	}

	public void setNpsn(String npsn){
		this.npsn = npsn;
	}

	public String getNpsn(){
		return npsn;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setTgglLahir(String tgglLahir){
		this.tgglLahir = tgglLahir;
	}

	public String getTgglLahir(){
		return tgglLahir;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setNamaSekolah(String namaSekolah){
		this.namaSekolah = namaSekolah;
	}

	public String getNamaSekolah(){
		return namaSekolah;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setKelasSaatIni(String kelasSaatIni){
		this.kelasSaatIni = kelasSaatIni;
	}

	public String getKelasSaatIni(){
		return kelasSaatIni;
	}
}