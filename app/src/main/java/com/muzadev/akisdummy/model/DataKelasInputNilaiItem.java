package com.muzadev.akisdummy.model;

import com.google.gson.annotations.SerializedName;

public class DataKelasInputNilaiItem{

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("id_kelas_diajar")
	private String idKelasDiajar;

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setIdKelasDiajar(String idKelasDiajar){
		this.idKelasDiajar = idKelasDiajar;
	}

	public String getIdKelasDiajar(){
		return idKelasDiajar;
	}
}