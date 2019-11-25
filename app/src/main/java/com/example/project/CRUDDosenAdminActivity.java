package com.example.project;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Model.DefaultResult;
import com.example.project.Network.GetDataService;
import com.example.project.Network.RetrofitClientInstance;
import retrofit2.Call;
import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class CRUDDosenAdminActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_dosen_admin);
        this.setTitle("SI KRS - ADMIN - CRUD Dosen");

        final EditText namaDosen = findViewById(R.id.edtxtNamaDosenCRUD);
        final EditText nidnDosen = findViewById(R.id.edtxtNIDNDosenCRUD);
        final EditText alamatDosen = findViewById(R.id.edtxtAlamatDosenCRUD);
        final EditText emailDosen = findViewById(R.id.edtxtEmailDosenCRUD);
        final EditText gelarDosen = findViewById(R.id.edtxtGelarDosenCRUD);
        EditText fotoDosen = findViewById(R.id.edtxtFotoDosenCRUD);

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
                        progressDialog = new ProgressDialog(CRUDDosenAdminActivity.this);
                        progressDialog.show();

                        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                        retrofit2.Call<DefaultResult> call = service.insert_dosen(
                                namaDosen.getText().toString(),
                                nidnDosen.getText().toString(),
                                alamatDosen.getText().toString(),
                                emailDosen.getText().toString(),
                                gelarDosen.getText().toString(),
                                "https://source.unsplash.com/random",
                                "72170115"
                        );
                        call.enqueue(new Callback<DefaultResult>() {
                            @Override
                            public void onResponse(retrofit2.Call<DefaultResult> call, Response<DefaultResult> response) {
                                progressDialog.dismiss();
                                Toast.makeText(CRUDDosenAdminActivity.this, "Data tersimpan",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CRUDDosenAdminActivity.this,MenuDosenAdminActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(retrofit2.Call<DefaultResult> call, Throwable t) {
                                Toast.makeText(CRUDDosenAdminActivity.this, "Data TIDAK tersimpan",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });/*Callback < DefaultResult > () {
                            @Override
                            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                                progressDialog.dismiss();
                                Toast.makeText(CRUDDosenAdminActivity.this, "Data tersimpan",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CRUDDosenAdminActivity.this,MenuDosenAdminActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<DefaultResult> call, Throwable t) {
                                Toast.makeText(CRUDDosenAdminActivity.this, "Data TIDAK tersimpan",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })*/
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
});
        }
}
