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
                    AlertDialog.Builder builder=new AlertDialog.Builder(CRUDKrs.this);
                    builder.setMessage("Apakah anda yakin akan menyimpan data? ")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(CRUDKrs.this, "Data tidak tersimpan",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(CRUDKrs.this,MenuDosenAdminActivity.class);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });
    }
}



