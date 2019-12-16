package com.muzadev.akisdummy.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.adapter.AdpSiswa;
import com.muzadev.akisdummy.model.SiswaResponse;
import com.muzadev.akisdummy.network.ApiSiswa;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllStudentsActivity extends AppCompatActivity {
    EditText etSearch;
    RecyclerView rvSiswa;
    AdpSiswa adpSiswa;
    ProgressBar pbSearch;
    PrefManager prefManager;
    ApiSiswa apiSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students);

        apiSiswa = RetrofitInstance.create().create(ApiSiswa.class);
        prefManager = new PrefManager(this);
        etSearch = findViewById(R.id.etSearch);
        pbSearch = findViewById(R.id.pbSearch);
        rvSiswa = findViewById(R.id.rvSiswa);
        adpSiswa = new AdpSiswa(this, false);
        rvSiswa.setLayoutManager(new LinearLayoutManager(this));
        rvSiswa.setAdapter(adpSiswa);

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    /*hit api*/
                    String searchQuery = v.getText().toString();
                    searchStudent(searchQuery);
                }
                pbSearch.setVisibility(View.VISIBLE);
                return true;
            }
        });
    }

    private void searchStudent(String searchQuery) {
        apiSiswa.searchSiswaByName(prefManager.getUser().getNpsn(), searchQuery, "duniamaya").enqueue(new Callback<SiswaResponse>() {
            @Override
            public void onResponse(Call<SiswaResponse> call, Response<SiswaResponse> response) {
                pbSearch.setVisibility(View.GONE);
                adpSiswa.setData(response.body().getSiswaList());
            }

            @Override
            public void onFailure(Call<SiswaResponse> call, Throwable t) {

            }
        });
    }


}
