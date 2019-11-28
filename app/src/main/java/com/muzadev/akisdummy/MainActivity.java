package com.muzadev.akisdummy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.akisdummy.model.LoginModel;
import com.muzadev.akisdummy.model.Siswa;
import com.muzadev.akisdummy.model.SiswaItem;
import com.muzadev.akisdummy.network.ApiLogin;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private ProgressBar pbLoading;
    private Button btnLogin, btnShowData, btnGetSiswa;
    private TextView tvData;
    private PrefManager prefManager;
    private View form;
    private View btn1, btn2, btn3, btn4, btn5, btn6;
    private GridLayout gridMenu;

    Retrofit retrofit = RetrofitInstance.create();
    ApiLogin apiLogin = retrofit.create(ApiLogin.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        prefManager = new PrefManager(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });

        btnGetSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String npsn = prefManager.getUser().getNpsn();
                getSiswa(npsn);
            }
        });
    }

    private void showData() {
        String namaGuru = prefManager.getUser().getNpsn();
        tvData.setText(namaGuru);
    }

    private void doLogin() {
        pbLoading.setVisibility(View.VISIBLE);

        String noHp = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        apiLogin.loginGuru(noHp, password)
                .enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        pbLoading.setVisibility(View.GONE);
                        String status = response.body().getStatus();

                        if (status.equals("true")) {
                            String role = response.body().getData().get(0).getLevel();
                            showForm(role);
                            prefManager.saveUser(response.body().getData().get(0));
                            Toast.makeText(MainActivity.this, "Behasil gan : " + role, Toast.LENGTH_SHORT).show();
                            Log.i("LOGIN", response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        pbLoading.setVisibility(View.GONE);
                        String error = t.getMessage();
                        Toast.makeText(MainActivity.this, "gAGAL GAN " + error, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showForm(final String role) {
        if (role.equals("Kepsek")) {
            gridMenu.removeView(btn5);
            gridMenu.removeView(btn3);
        }
    }

    private void getSiswa(String npsn) {
        apiLogin.getSiswa(npsn).enqueue(new Callback<Siswa>() {
            @Override
            public void onResponse(Call<Siswa> call, Response<Siswa> response) {
                String nama = "";
                for (SiswaItem siswa : response.body().getSiswa()) {
                    nama = siswa.getName() + "\n";
                }

                tvData.setText(nama);
            }

            @Override
            public void onFailure(Call<Siswa> call, Throwable t) {
                /*TODO*/
            }
        });
    }

    private void bindView() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGetSiswa = findViewById(R.id.btnGetSiswa);
        btnShowData = findViewById(R.id.btnShowData);
        pbLoading = findViewById(R.id.pbLogin);
        tvData = findViewById(R.id.tvData);

        gridMenu = findViewById(R.id.gridMenu);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
    }
}
