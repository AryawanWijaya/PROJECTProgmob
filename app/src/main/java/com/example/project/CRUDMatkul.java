package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CRUDMatkul extends AppCompatActivity {
    private String [] hari = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Minggu"};
    private String [] sesi = {"Sesi1","Sesi2","Sesi3","Sesi4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudmatkul);
        this.setTitle("SI KRS - ADMIN - CRUD Matkul");
        Button btnSimpanMatkul =findViewById(R.id.btnSimpanMatkulCRUD);


        //Spinner hari
        Spinner spinner = findViewById(R.id.spnHariMatkulCRUD);
        ArrayAdapter<String> hariAdapter =new ArrayAdapter<>(CRUDMatkul.this,android.R.layout.simple_list_item_1,hari);
        spinner.setAdapter(hariAdapter);

        Spinner spinner1=findViewById(R.id.spnSesiMatkulCRUD);
        ArrayAdapter<String> sesiAdapter = new ArrayAdapter<>(CRUDMatkul.this,android.R.layout.simple_list_item_1,sesi);
        spinner1.setAdapter(sesiAdapter);

        btnSimpanMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CRUDMatkul.this,MenuDosenAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
