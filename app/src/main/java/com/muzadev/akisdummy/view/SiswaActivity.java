package com.muzadev.akisdummy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.adapter.AdpSiswa;
import com.muzadev.akisdummy.model.SiswaResponse;
import com.muzadev.akisdummy.network.ApiSiswa;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.AppParams;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SiswaActivity extends AppCompatActivity {
    private AdpSiswa adpSiswa;
    private RecyclerView rvSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);
        String idKelas = getIntent().getStringExtra(AppParams.IDKELAS);

        adpSiswa = new AdpSiswa(this);
        rvSiswa = findViewById(R.id.rvSiswa);
        rvSiswa.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rvSiswa.setLayoutManager(new LinearLayoutManager(this));
        rvSiswa.setAdapter(adpSiswa);

        getDataSiswaPerKelas(idKelas);
    }

    private void getDataSiswaPerKelas(String idKelas) {
        ApiSiswa apiSiswa = RetrofitInstance.create().create(ApiSiswa.class);

        apiSiswa.getSiswaPerkelas(idKelas, "duniamaya").enqueue(new Callback<SiswaResponse>() {
            @Override
            public void onResponse(Call<SiswaResponse> call, Response<SiswaResponse> response) {
                adpSiswa.setData(response.body().getSiswaList());
            }

            @Override
            public void onFailure(Call<SiswaResponse> call, Throwable t) {

            }
        });
    }
}
