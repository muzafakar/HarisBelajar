package com.muzadev.akisdummy.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.adapter.AdpKelas;
import com.muzadev.akisdummy.model.Kelas;
import com.muzadev.akisdummy.model.KelasResponse;
import com.muzadev.akisdummy.network.ApiSiswa;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.PrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {
    private PrefManager prefManager;
    private AdpKelas adpKelas;
    private RecyclerView rvKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        prefManager = new PrefManager(this);
        adpKelas = new AdpKelas(this);

        rvKelas = findViewById(R.id.rvKelas);
        rvKelas.setLayoutManager(new LinearLayoutManager(this));
        rvKelas.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rvKelas.setAdapter(adpKelas);

        getAllKelas();
    }

    private void getAllKelas() {
        Retrofit retrofit = RetrofitInstance.create();
        ApiSiswa apiSiswa = retrofit.create(ApiSiswa.class);
        String npsn = prefManager.getUser().getNpsn();
        String password = "duniamaya";

        apiSiswa.getAllKelas(npsn, password).enqueue(new Callback<KelasResponse>() {
            @Override
            public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                List<Kelas> data = response.body().getListKelas();
                adpKelas.setData(data);
                Log.d("KELAS RESPONSE", data.toString());
            }

            @Override
            public void onFailure(Call<KelasResponse> call, Throwable t) {

            }
        });
    }

}
