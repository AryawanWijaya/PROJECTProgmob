package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
                    AlertDialog.Builder builder=new AlertDialog.Builder(CRUDMatkul.this);
                    builder.setMessage("Apakah anda yakin akan menyimpan data? ")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(CRUDMatkul.this, "Data tidak tersimpan",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(CRUDMatkul.this,MenuDosenAdminActivity.class);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });
    }
}
