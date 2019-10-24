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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.project.Adapter.MatkulAdapter;
import com.example.project.Model.Matkul;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecycleViewMatkulActivity extends AppCompatActivity {


    private ArrayList<Matkul>matkulArrayList;
    private RecyclerView recyclerView;
    private MatkulAdapter matkulAdapter;

    //nampilin titik tiga
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    //menu create
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecycleViewMatkulActivity.this,CRUDMatkul.class);
            startActivity(intent);
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_matkul);
        this.setTitle("SI KRS - HAI ARY - Daftar Matkul");
        addData();
        recyclerView =findViewById(R.id.rvMatkul);
        matkulAdapter = new MatkulAdapter(matkulArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(RecycleViewMatkulActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(matkulAdapter);



    }

    private void addData(){
        matkulArrayList = new ArrayList<>();
        matkulArrayList.add(new Matkul("001","Progmob","Rabu","Sesi 4","3 SKS"));
        matkulArrayList.add(new Matkul("002","Progweb","Selasa","Sesi 3","3 SKS"));
        matkulArrayList.add(new Matkul("003","ABD","Rabu","Sesi 1","3 SKS"));
        matkulArrayList.add(new Matkul("004","ASD","Senin","Sesi 1","3 SKS"));
    }
}
