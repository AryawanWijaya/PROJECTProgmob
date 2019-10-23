package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project.Adapter.DosenAdapter;
import com.example.project.Model.Dosen;

import java.util.ArrayList;

public class RecycleViewDosenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_dosen);
        addData();
        recyclerView =findViewById(R.id.rvDosen);
        dosenAdapter=new DosenAdapter(dosenArrayList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(RecycleViewDosenActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dosenAdapter);
    }

    private void addData(){
        dosenArrayList=new ArrayList<>();
        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12345","JJS","Master Statistic","JJS@staff.ukdw.ac.id","Jogja"));
        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12346","Argo Wibowo","Master Coding","argo@staff.ukdw.ac.id","Jogja"));
        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12347","Katon Wijana","Master Coding","katon@staff.ukdw.ac.id","Jogja"));
    }
}
