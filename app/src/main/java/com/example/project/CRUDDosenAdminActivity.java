package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CRUDDosenAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_dosen_admin);
        this.setTitle("SI KRS - ADMIN - CRUD Dosen");
        Button btnSimpan = findViewById(R.id.btnSimpanDosenCRUD);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CRUDDosenAdminActivity.this,MenuDosenAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
