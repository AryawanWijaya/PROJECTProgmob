package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CRUDKrs extends AppCompatActivity {

    private String [] Dosen = {"JJS","Argo","Katon"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudkrs);
        this.setTitle("SI KRS - ADMIN - CRUD KRS");
        Button btnSimpanKrs = findViewById(R.id.btnSimpanKrsCRUD);

        Spinner spinner = findViewById(R.id.spnDosenKrsCRUD);
        ArrayAdapter<String> dosen = new ArrayAdapter<>(CRUDKrs.this,android.R.layout.simple_list_item_1,Dosen);
        spinner.setAdapter(dosen);

        btnSimpanKrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CRUDKrs.this,MenuDosenAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
