package com.muzadev.akisdummy.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.model.DataKelasInputNilaiItem;
import com.muzadev.akisdummy.model.NilaiResponse;
import com.muzadev.akisdummy.network.ApiSiswa;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NilaiActivity extends AppCompatActivity {
    private Spinner spClass;
    private ArrayAdapter<String> adpClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        adpClass = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        spClass = findViewById(R.id.spClass);
        spClass.setAdapter(adpClass);

        String idGuru = new PrefManager(this).getUser().getIdPengguna();
        getMyClass(idGuru);
    }

    private void getMyClass(String idGuru) {
        Log.i("DATA KELAS", idGuru);
        ApiSiswa apiSiswa = RetrofitInstance.create().create(ApiSiswa.class);

        apiSiswa.getMyClass(idGuru, "duniamaya").enqueue(new Callback<NilaiResponse>() {
            @Override
            public void onResponse(Call<NilaiResponse> call, Response<NilaiResponse> response) {
                for (DataKelasInputNilaiItem kelas : response.body().getDataKelasInputNilai()) {
                    String item = kelas.getIdKelasDiajar() + "\n" + kelas.getNamaKelas();
                    adpClass.add(item);
                    adpClass.notifyDataSetChanged();

                    Log.i("DATA KELAS", kelas.toString());
                }
            }

            @Override
            public void onFailure(Call<NilaiResponse> call, Throwable t) {

            }
        });
    }
}
