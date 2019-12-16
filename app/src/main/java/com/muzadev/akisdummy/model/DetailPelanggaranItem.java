package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

public class DetailPelanggaranItem {

	@SerializedName("id_kategori")
	private String idKategori;

	@SerializedName("id")
	private String id;

	@SerializedName("deskripsi_pelanggaran")
	private String deskripsiPelanggaran;

	@SerializedName("point")
	private String point;

	@SerializedName("npsn")
	private String npsn;

	@SerializedName("status")
	private String status;

	public String getIdKategori(){
		return idKategori;
	}

	public String getId(){
		return id;
	}

	public String getDeskripsiPelanggaran(){
		return deskripsiPelanggaran;
	}

	public String getPoint(){
		return point;
	}

	public String getNpsn(){
		return npsn;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DetailPelanggaranItem{" +
			"id_kategori = '" + idKategori + '\'' + 
			",id = '" + id + '\'' + 
			",deskripsi_pelanggaran = '" + deskripsiPelanggaran + '\'' + 
			",point = '" + point + '\'' + 
			",npsn = '" + npsn + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}