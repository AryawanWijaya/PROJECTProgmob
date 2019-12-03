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
import com.example.project.Model.DefaultResult;
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
    private ArrayList<Dosen> dosenList;
    ProgressDialog progressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            Intent intent = new Intent(RecycleViewDosenActivity.this, CRUDDosenAdminActivity.class);
            startActivity(intent);
        }
        return true;
    }
//hapus dan edit
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Dosen dosen = dosenList.get(item.getGroupId());
        if (item.getTitle() == "UBAH DATA") {
            Intent intent = new Intent(RecycleViewDosenActivity.this, CRUDDosenAdminActivity.class);
            intent.putExtra("id_dosen", dosen.getId());
            intent.putExtra("nama_dosen", dosen.getNamaDosen());
            intent.putExtra("nidn", dosen.getNIDN());
            intent.putExtra("alamat", dosen.getAlamat());
            intent.putExtra("email", dosen.getEmail());
            intent.putExtra("gelar", dosen.getGelar());
            intent.putExtra("foto", dosen.getFotoDosen());
            intent.putExtra("is_update", true);
            startActivity(intent);
        } else if (item.getTitle() == "HAPUS DATA") {
            progressDialog = new ProgressDialog(RecycleViewDosenActivity.this);
            progressDialog.setMessage("Proses menghapus data sabar yaaa");
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_dosen(
                    dosen.getId(),
                    "72170115"
            );
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(RecycleViewDosenActivity.this, "DATA TERHAPUS", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RecycleViewDosenActivity.this, RecycleViewDosenActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();

                    Toast.makeText(RecycleViewDosenActivity.this, "DATA TIDAK TERHAPUS", Toast.LENGTH_LONG).show();
                }
            });
        }
        return super.onContextItemSelected(item);
    }

//getData
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_dosen);
        this.setTitle("SI KRS - HAI ARY - Daftar Dosen");
        recyclerView =findViewById(R.id.rvDosen);

//        addData();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sabar cuyy masih loading");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Dosen>>call = service.getDosenAll("72170115");
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
                progressDialog.dismiss();

                dosenList=response.body();
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

        registerForContextMenu(recyclerView);//utk nyantolke context menuyang ada di adapter
    }

//    private void addData(){
//        dosenArrayList=new ArrayList<>();
//        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12345","JJS","Master Statistic","JJS@staff.ukdw.ac.id","Jogja"));
//        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12346","Argo Wibowo","Master Coding","argo@staff.ukdw.ac.id","Jogja"));
//        dosenArrayList.add(new Dosen(R.drawable.logo_dosen, "12347","Katon Wijana","Master Coding","katon@staff.ukdw.ac.id","Jogja"));
//    }
}
