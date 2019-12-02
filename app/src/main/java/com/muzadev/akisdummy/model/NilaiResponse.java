package com.muzadev.akisdummy.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NilaiResponse{

	@SerializedName("data_kelas_input_nilai")
	private List<DataKelasInputNilaiItem> dataKelasInputNilai;

	public void setDataKelasInputNilai(List<DataKelasInputNilaiItem> dataKelasInputNilai){
		this.dataKelasInputNilai = dataKelasInputNilai;
	}

	public List<DataKelasInputNilaiItem> getDataKelasInputNilai(){
		return dataKelasInputNilai;
	}
}