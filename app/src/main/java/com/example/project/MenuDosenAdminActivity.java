package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuDosenAdminActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.miCompose){

                AlertDialog.Builder builder=new AlertDialog.Builder(MenuDosenAdminActivity.this);
                builder.setMessage("Apakah anda yakin ingin keluar? ")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MenuDosenAdminActivity.this, "Yeee Anda tidak jadi Keluar :)",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences prefs = MenuDosenAdminActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
                                String statusLogin = prefs.getString("isLogin",null);
                                SharedPreferences.Editor edit = prefs.edit();
                                edit.putString("isLogin",null);
                                edit.commit();
                                Intent intent = new Intent(MenuDosenAdminActivity.this,SplashScreenActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return true;
    }




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
