package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.project.Adapter.LihatKelasAdapter;
import com.example.project.Model.LihatKelas;

import java.util.ArrayList;

public class RecycleViewLihatKelas extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecycleViewLihatKelas.this,CRUDMhsActivity.class);
            startActivity(intent);
        }
        return true;
    }

    private ArrayList<LihatKelas>lihatKelasArrayList;
    private RecyclerView recyclerView;
    private LihatKelasAdapter lihatKelasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_lihat_kelas);
        this.setTitle("SI KRS - HAI ARY - Daftar Kelas");
        addData();

        recyclerView = findViewById(R.id.rvLihatKelas);
        lihatKelasAdapter = new LihatKelasAdapter(lihatKelasArrayList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(RecycleViewLihatKelas.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(lihatKelasAdapter);
    }

    private void addData(){
        lihatKelasArrayList = new ArrayList<>();
        lihatKelasArrayList.add(new LihatKelas("001","Progmob","Rabu","Sesi 4","Argo","20mhs"));
        lihatKelasArrayList.add(new LihatKelas("002","Progweb","Selasa","Sesi 3","Erick","30mhs"));
        lihatKelasArrayList.add(new LihatKelas("003","ABD","Rabu","Sesi 1","Argo","43mhs"));
    }
}
