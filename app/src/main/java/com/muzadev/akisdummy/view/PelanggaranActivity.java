package com.muzadev.akisdummy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.model.DetailPelanggaranItem;
import com.muzadev.akisdummy.model.Pelanggaran;
import com.muzadev.akisdummy.model.PelanggaranDescResponse;
import com.muzadev.akisdummy.model.PelanggaranResponse;
import com.muzadev.akisdummy.network.ApiPelanggaran;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.PrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PelanggaranActivity extends AppCompatActivity {
    ApiPelanggaran apiPelanggaran;
    PrefManager prefManager;
    ArrayAdapter<String> adpPelanggaran, adpDesc;

    Spinner spPelanggaran, spDesc;
    String npsn;
    String password = "duniamaya";

    List<Pelanggaran> pelanggaranList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggaran);

        apiPelanggaran = RetrofitInstance.create().create(ApiPelanggaran.class);
        prefManager = new PrefManager(this);
        npsn = prefManager.getUser().getNpsn();

        adpPelanggaran = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adpDesc = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        spPelanggaran = findViewById(R.id.spPelanggaran);
        spDesc = findViewById(R.id.spDeskripsi);

        spPelanggaran.setAdapter(adpPelanggaran);
        spDesc.setAdapter(adpDesc);

        getPelanggaran();
    }

    void getPelanggaran() {
        apiPelanggaran.getPelanggaran(npsn, password)
                .enqueue(new Callback<PelanggaranResponse>() {
                    @Override
                    public void onResponse(Call<PelanggaranResponse> call, Response<PelanggaranResponse> response) {
                        pelanggaranList.clear();
                        pelanggaranList = response.body().getListKategori();
                        List<String> string = new ArrayList<>();
                        for (Pelanggaran pelanggaran : pelanggaranList) {
                            string.add(pelanggaran.getKategoriPelanggaran());
                        }
                        adpPelanggaran.clear();
                        adpPelanggaran.addAll(string);

                    }

                    @Override
                    public void onFailure(Call<PelanggaranResponse> call, Throwable t) {

                    }
                });

        spPelanggaran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getDeskripsi(pelanggaranList.get(position).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void getDeskripsi(String idPelanggaran) {
        apiPelanggaran.getPelanggaranDesc(npsn, idPelanggaran, password).enqueue(new Callback<PelanggaranDescResponse>() {
            @Override
            public void onResponse(Call<PelanggaranDescResponse> call, Response<PelanggaranDescResponse> response) {
                List<DetailPelanggaranItem> data = response.body().getDetailKategori();
                List<String> string = new ArrayList<>();
                for (DetailPelanggaranItem pelanggaran : data) {
                    string.add(pelanggaran.getDeskripsiPelanggaran());
                }
                adpDesc.clear();
                adpDesc.addAll(string);
            }

            @Override
            public void onFailure(Call<PelanggaranDescResponse> call, Throwable t) {

            }
        });
    }
}
