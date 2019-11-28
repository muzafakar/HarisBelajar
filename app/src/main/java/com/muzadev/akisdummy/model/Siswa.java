package com.muzadev.akisdummy.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Siswa{

	@SerializedName("siswa")
	private List<SiswaItem> siswa;

	public void setSiswa(List<SiswaItem> siswa){
		this.siswa = siswa;
	}

	public List<SiswaItem> getSiswa(){
		return siswa;
	}
}