package com.muzadev.akisdummy.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.akisdummy.R;
import com.muzadev.akisdummy.util.PrefManager;

public class MainActivity extends AppCompatActivity {
    private Button btnPelanggaran, btnSiswa, btnSurat, btnNilai;
    private PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        prefManager = new PrefManager(this);
        /*TODO check role*/
        int level = prefManager.getUser().getLevel();
        roleChecker(level);


        btnSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NilaiActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bindView() {
        btnPelanggaran = findViewById(R.id.btnPelanggaran);
        btnSiswa = findViewById(R.id.btnSiswa);
        btnSurat = findViewById(R.id.btnSurat);
        btnNilai = findViewById(R.id.btnNilai);
    }

    private void roleChecker(int role) {
        switch (role) {
            case 1: { /*Kepsek*/
                btnSiswa.setVisibility(View.VISIBLE);
                break;
            }
            case 2: { /*BK*/
                btnSurat.setVisibility(View.VISIBLE);
                break;
            }
            case 3: { /*TU*/
                // nothing to show
                break;
            }
            case 4: { /*Guru kelas*/
                btnPelanggaran.setVisibility(View.VISIBLE);
                btnNilai.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuLogout) {
            prefManager.deleteGuru();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
