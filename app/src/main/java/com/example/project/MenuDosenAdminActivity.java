package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuDosenAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dosen_admin);
        ImageButton btnDaftarDosen = findViewById(R.id.btnDaftarDosenAdmin);

        btnDaftarDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenAdminActivity.this,RecycleViewDosenActivity.class);
                startActivity(intent);
            }
        });

    }
}
