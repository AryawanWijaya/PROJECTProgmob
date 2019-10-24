package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CRUDMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudmhs);
        this.setTitle("SI KRS - ADMIN - CRUD Mahasiswa");

        Button btnSimpanMhs = findViewById(R.id.btnSimpanMhsCRUD);

        btnSimpanMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CRUDMhsActivity.this, MenuDosenAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
