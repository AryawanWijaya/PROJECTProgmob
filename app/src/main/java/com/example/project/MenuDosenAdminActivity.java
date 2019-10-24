package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuDosenAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dosen_admin);
        this.setTitle("SI KRS - ADMIN-HAI ARY");
        ImageButton btnDaftarDosen = findViewById(R.id.btnDaftarDosenAdmin);
        ImageButton btnDataDiri = findViewById(R.id.btnDataDiriDosenAdmin);
        ImageButton btnDaftarKrs = findViewById(R.id.btnKelolaKrsAdmin);
        ImageButton btnDaftarMatkul = findViewById(R.id.btnKelolaDaftarAdmin);
        ImageButton btnDaftarMhs = findViewById(R.id.btnDaftarMhsAdmin);

        btnDaftarDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenAdminActivity.this,RecycleViewDosenActivity.class);
                startActivity(intent);
            }
        });

        btnDataDiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenAdminActivity.this,CRUDDosenAdminActivity.class);
                startActivity(intent);
            }
        });

        btnDaftarKrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuDosenAdminActivity.this, RecycleViewKrsActivity.class);
                startActivity(intent);
            }
        });

        btnDaftarMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenAdminActivity.this, RecycleViewMatkulActivity.class);
                startActivity(intent);
            }
        });

        btnDaftarMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenAdminActivity.this,RecycleViewMahasiswaActivity.class);
                startActivity(intent);
            }
        });


    }
}
