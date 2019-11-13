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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuDosenActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.miCompose){

            AlertDialog.Builder builder=new AlertDialog.Builder(MenuDosenActivity.this);
            builder.setMessage("Apakah anda yakin ingin keluar? ")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MenuDosenActivity.this, "Yeee Anda tidak jadi Keluar :)",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences prefs = MenuDosenActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
                            String statusLogin = prefs.getString("isLogin",null);
                            SharedPreferences.Editor edit = prefs.edit();
                            edit.putString("isLogin",null);
                            edit.commit();
                            Intent intent = new Intent(MenuDosenActivity.this,SplashScreenActivity.class);
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
        setContentView(R.layout.activity_menu_dosen);
        this.setTitle("SI KRS - Client -HAI ARY");
        ImageButton btnLihatKelas = findViewById(R.id.btnLihatKelas);
        ImageButton btnLihatKrs = findViewById(R.id.btnLihatKrs);
        ImageButton btnLihatDataDiri = findViewById(R.id.btnDataDiriDosen);

        btnLihatDataDiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenActivity.this,CRUDMhsActivity.class);
                startActivity(intent);
            }
        });
        btnLihatKelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenActivity.this, RecycleViewLihatKelas.class);
                startActivity(intent);
            }
        });
        btnLihatKrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuDosenActivity.this,RecycleViewKrsActivity.class);
                startActivity(intent);
            }
        });

    }
}
