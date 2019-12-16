package com.muzadev.akisdummy.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.adapter.AdpSiswa;
import com.muzadev.akisdummy.model.Siswa;
import com.muzadev.akisdummy.model.SiswaResponse;
import com.muzadev.akisdummy.network.ApiSiswa;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.AppParams;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiswaActivity extends AppCompatActivity {
    AdpSiswa adpSiswa;
    RecyclerView rvSiswa;
    EditText etSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);
        Toolbar tbCommon = findViewById(R.id.tbCommon);
        tbCommon.setTitle("Data Siswa");
        setupSearch();
        setSupportActionBar(tbCommon);

        String idKelas = getIntent().getStringExtra(AppParams.IDKELAS);
        String namaGuru = getIntent().getStringExtra(AppParams.TEACHER_NAME);
//        Siswa parcelSiswa = (Siswa) getIntent().getParcelableExtra("ASDF");
        tbCommon.setSubtitle(namaGuru);

        adpSiswa = new AdpSiswa(this);
        rvSiswa = findViewById(R.id.rvSiswa);
        rvSiswa.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rvSiswa.setLayoutManager(new LinearLayoutManager(this));
        rvSiswa.setAdapter(adpSiswa);

        getDataSiswaPerKelas(idKelas);
    }

    private void setupSearch() {
        LinearLayout tbMenuContainer = findViewById(R.id.tbMenuContainer);
        etSearch = new EditText(this);
        etSearch.setHint("Cari Siswa");
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString();
                adpSiswa.searchData(query);
                // datanya di filter berdasarkan query
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        tbMenuContainer.addView(etSearch);
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
