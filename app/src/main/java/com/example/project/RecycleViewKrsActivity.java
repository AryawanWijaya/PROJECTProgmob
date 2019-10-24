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

import com.example.project.Adapter.KRSAdapter;
import com.example.project.Model.KRS;

import java.util.ArrayList;

public class RecycleViewKrsActivity extends AppCompatActivity {

    private ArrayList<KRS>krsArrayList;
    private KRSAdapter krsAdapter;
    private RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecycleViewKrsActivity.this,CRUDKrs.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_krs);
        this.setTitle("SI KRS - HAI ARY - Daftar KRS");

        addData();
        recyclerView =findViewById(R.id.rvKrs);
        krsAdapter = new KRSAdapter(krsArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(RecycleViewKrsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(krsAdapter);

    }

    private void addData(){
        krsArrayList=new ArrayList<>();
        krsArrayList.add(new KRS("001","Progmob","Rabu","Sesi 4","3 SKS","Argo Wibowo","20 mhs"));
        krsArrayList.add(new KRS("002","Progweb","Selasa","Sesi 3","3 SKS","Erick","30 mhs"));
        krsArrayList.add(new KRS("003","ABD","Rabu","Sesi 1","3 SKS","Katon","43 mhs"));
        krsArrayList.add(new KRS("004","ASD","Senin","Sesi 1","3 SKS","Katon","40 mhs"));

    }

}
