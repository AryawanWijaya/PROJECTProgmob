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
import com.example.project.Model.DefaultResult;
import com.example.project.Model.Mahasiswa;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.project.Network.GetDataService;
import com.example.project.Network.RetrofitClientInstance;
import android.app.ProgressDialog;
import android.widget.Toast;

public class RecycleViewMahasiswaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa>mahasiswaArrayList;
    private ProgressDialog progressDialog;

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
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Mahasiswa mhs = mahasiswaArrayList.get(item.getGroupId());
        if(item.getTitle() == "UBAH DATA"){
            Intent intent = new Intent(RecycleViewMahasiswaActivity.this,CRUDMhsActivity.class);
            intent.putExtra("id_mhs",mhs.getId());
            intent.putExtra("nama_mhs",mhs.getNamaMhs());
            intent.putExtra("nim",mhs.getNIM());
            intent.putExtra("alamat_mhs",mhs.getAlamaMhs());
            intent.putExtra("email_mhs",mhs.getEmailMhs());
            intent.putExtra("foto_mhs",mhs.getImgMhs());
            intent.putExtra("is_update",true);
            startActivity(intent);

        }else if(item.getTitle() == "HAPUS DATA"){
            progressDialog = new ProgressDialog(RecycleViewMahasiswaActivity.this);
            progressDialog.setMessage("Proses menghapus data sabar yaaa");
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_mhs(
                    mhs.getId(),
                    "72170115"
            );
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(RecycleViewMahasiswaActivity.this, "DATA TERHAPUS", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RecycleViewMahasiswaActivity.this, RecycleViewMahasiswaActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();

                    Toast.makeText(RecycleViewMahasiswaActivity.this, "DATA TIDAK TERHAPUS", Toast.LENGTH_LONG).show();
                }
            });
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_mahasiswa);
        this.setTitle("SI KRS - HAI ARY - Daftar Mahasiswa");
        recyclerView=findViewById(R.id.rvMahasiswa);
//        addData();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sabar yaa");
        progressDialog.show();


        GetDataService service= RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Mahasiswa>> call = service.getMahasiswa("72170115");
        call.enqueue(new Callback<ArrayList<Mahasiswa>>() {
            @Override
            public void onResponse(Call<ArrayList<Mahasiswa>> call, Response<ArrayList<Mahasiswa>> response) {
                progressDialog.dismiss();

                mahasiswaArrayList = response.body();
                mahasiswaAdapter = new MahasiswaAdapter(response.body());

                RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(RecycleViewMahasiswaActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(mahasiswaAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Mahasiswa>> call, Throwable t) {
                Toast.makeText(RecycleViewMahasiswaActivity.this,"Login Gagal",Toast.LENGTH_LONG);
            }
        });

        registerForContextMenu(recyclerView);
    }

    /*private void addData(){
        mahasiswaArrayList=new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa(R.drawable.logo_mahasiswa,"72170115","Ary","nikolaus.wijaya@si.ukdw.ac.id","Kudus"));
        mahasiswaArrayList.add(new Mahasiswa(R.drawable.logo_mahasiswa,"72170139","Candra","didimus.candra@si.ukdw.ac.id","Kalimantan"));
        mahasiswaArrayList.add(new Mahasiswa(R.drawable.logo_mahasiswa,"72170177","Beni","beni.mulia@si.ukdw.ac.id","Jogja"));
    }*/
}
