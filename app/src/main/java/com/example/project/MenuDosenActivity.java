package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuDosenActivity extends AppCompatActivity {

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
