package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.project.Adapter.DosenAdapter;
import com.example.project.Model.Dosen;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.project.Network.GetDataService;
import com.example.project.Network.RetrofitClientInstance;

public class RecycleViewDosenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenArrayList;
    ProgressDialog progressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecycleViewDosenActivity.this,CRUDDosenAdminActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_dosen);
        this.setTitle("SI KRS - HAI ARY - Daftar Dosen");

//        addData();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sabar cuyy masih loading");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Dosen>>call = service.getDosenAll("721600012");
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
                progressDialog.dismiss();

                recyclerView =findViewById(R.id.rvDosen);
                dosenAdapter=new DosenAdapter(response.body());

                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(RecycleViewDosenActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {
                Toast.makeText(RecycleViewDosenActivity.this,"Login Gagal, Coba Lagi",Toast.LENGTH_SHORT);
            }
        });


    }

//    private void addData(){
//        dosenArrayList=new ArrayList<>();
//        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12345","JJS","Master Statistic","JJS@staff.ukdw.ac.id","Jogja"));
//        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12346","Argo Wibowo","Master Coding","argo@staff.ukdw.ac.id","Jogja"));
//        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12347","Katon Wijana","Master Coding","katon@staff.ukdw.ac.id","Jogja"));
//    }
}
