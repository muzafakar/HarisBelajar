package com.muzadev.akisdummy.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.model.Guru;
import com.muzadev.akisdummy.util.PrefManager;

public class SplashActivity extends AppCompatActivity {
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefManager = new PrefManager(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                closeSplash();
            }
        }, 3000);
    }

    private void closeSplash() {
        Guru guru = prefManager.getUser();

        if (guru != null) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        finish();
    }
}
