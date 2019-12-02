package com.muzadev.akisdummy.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.model.LoginModel;
import com.muzadev.akisdummy.network.ApiLogin;
import com.muzadev.akisdummy.network.RetrofitInstance;
import com.muzadev.akisdummy.util.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private ProgressBar pbLoading;
    private PrefManager prefManager;
    private Button btnLogin;

    Retrofit retrofit = RetrofitInstance.create();
    ApiLogin apiLogin = retrofit.create(ApiLogin.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefManager = new PrefManager(this);

        bindView();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

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
                            prefManager.saveUser(response.body().getData().get(0));
                            Log.i("LOGIN", response.body().toString());

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        pbLoading.setVisibility(View.GONE);
                        String error = t.getMessage();
                        Toast.makeText(LoginActivity.this, "gAGAL GAN " + error, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void bindView() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        pbLoading = findViewById(R.id.pbLogin);
    }
}
