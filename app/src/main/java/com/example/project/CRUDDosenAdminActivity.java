package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        AlertDialog.Builder builder=new AlertDialog.Builder(CRUDDosenAdminActivity.this);
        builder.setMessage("Apakah anda yakin akan menyimpan data? ")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CRUDDosenAdminActivity.this, "Data tidak tersimpan",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(CRUDDosenAdminActivity.this,MenuDosenAdminActivity.class);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
});
        }
}
