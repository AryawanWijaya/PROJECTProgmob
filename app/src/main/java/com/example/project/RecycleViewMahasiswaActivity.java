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

import com.example.project.Adapter.MahasiswaAdapter;
import com.example.project.Model.Mahasiswa;

import java.util.ArrayList;

public class RecycleViewMahasiswaActivity extends AppCompatActivity {

    private ArrayList<Mahasiswa>mahasiswaArrayList;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecycleViewMahasiswaActivity.this,CRUDMhsActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_mahasiswa);
        this.setTitle("SI KRS - HAI ARY - Daftar Mahasiswa");
        addData();
        recyclerView=findViewById(R.id.rvMahasiswa);
        mahasiswaAdapter = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(RecycleViewMahasiswaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mahasiswaAdapter);
    }

    private void addData(){
        mahasiswaArrayList=new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa(R.drawable.logo_mahasiswa,"72170115","Ary","nikolaus.wijaya@si.ukdw.ac.id","Kudus"));
        mahasiswaArrayList.add(new Mahasiswa(R.drawable.logo_mahasiswa,"72170139","Candra","didimus.candra@si.ukdw.ac.id","Kalimantan"));
        mahasiswaArrayList.add(new Mahasiswa(R.drawable.logo_mahasiswa,"72170177","Beni","beni.mulia@si.ukdw.ac.id","Jogja"));
    }
}
