package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.Model.DefaultResult;
import com.example.project.Network.GetDataService;
import com.example.project.Network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CRUDMhsActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 58; // bebas asal nanti dipakai terus di activity yang laen, utk cek permissionnya
    private static final int PERMISSION_REQUEST_STORAGE = 58;
    private static final int GALERY_REQUEST_CODE = 58;
    private Uri uri;
    private ImageView imgThumb;
    private String stringImg;


    EditText nim, nama, alamat, email, foto;
    Button btnSimpanMhs, btnBrowse;
    Boolean isUpdate = false;
    String idMhs;
    ProgressDialog progressDialog;
    private String txtNama, txtNim, txtAlamat, txtEmail;
    Boolean isValid = true;

    public boolean validasiInput() {
        txtNama = nama.getText().toString();
        txtNim = nim.getText().toString();
        txtAlamat = alamat.getText().toString();
        txtEmail = email.getText().toString();


        if (TextUtils.isEmpty(txtNama)) {
            nama.setError("Nama Tidak Boleh Kosong");
            isValid = false;
        }
        if (TextUtils.isEmpty(txtNim)) {
            nim.setError("Nim Tidak Boleh Kosong");
            isValid = false;
        }
        if (TextUtils.isEmpty(txtAlamat)) {
            alamat.setError("Alamat Tidak Boleh Kosong");
            isValid = false;
        }
        if (TextUtils.isEmpty(txtEmail)) {
            email.setError("Email Tidak Boleh Kosong");
            isValid = false;
        }
        return isValid;
    }

    void checkUpdate() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        isUpdate = extras.getBoolean("is_update");
        idMhs = extras.getString("id_mhs");
        nama.setText(extras.getString("nama_mhs"));
        nim.setText(extras.getString("nim"));
        alamat.setText(extras.getString("alamat_mhs"));
        email.setText(extras.getString("email_mhs"));
        foto.setText(extras.getString("foto_mhs"));
        Picasso.with(this).
                load("https://kpsi.fti.ukdw.ac.id/progmob/"+extras.get("foto_mhs"))
                .into(imgThumb);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudmhs);
        this.setTitle("SI KRS - ADMIN - CRUD Mahasiswa");
        btnSimpanMhs = findViewById(R.id.btnSimpanMhsCRUD);
        nim = findViewById(R.id.edtxtNIMCRUD);
        nama = findViewById(R.id.edtxtNamaMhsCRUD);
        alamat = findViewById(R.id.edtxtAlamatMhsCRUD);
        email = findViewById(R.id.edtxtEmailMhsCRUD);
        foto = findViewById(R.id.edtxtFotoMhsCRUD);
        btnBrowse=findViewById(R.id.btnBrowseFotoMhs);

        imgThumb=findViewById(R.id.imgMhsView);
        checkUpdate();

        if (isUpdate) {
            btnSimpanMhs.setText("UPDATE");
        }
        btnSimpanMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiInput();
                if (isValid) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CRUDMhsActivity.this);
                    builder.setMessage("Apakah anda yakin akan menyimpan data? ")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(CRUDMhsActivity.this, "Data tidak tersimpan",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (!isUpdate) {
                                        progressDialog = new ProgressDialog(CRUDMhsActivity.this);
                                        progressDialog.setMessage("Sabar masih proses simpan");
                                        progressDialog.show();

                                        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                        Call<DefaultResult> call = service.add_mhs(
                                                nama.getText().toString(),
                                                nim.getText().toString(),
                                                alamat.getText().toString(),
                                                email.getText().toString(),
                                                stringImg,
                                                "72170115"
                                        );
                                        call.enqueue(new Callback<DefaultResult>() {
                                            @Override
                                            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                                                progressDialog.dismiss();

                                                Toast.makeText(CRUDMhsActivity.this, "Data tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(CRUDMhsActivity.this, RecycleViewMahasiswaActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(Call<DefaultResult> call, Throwable t) {
                                                Toast.makeText(CRUDMhsActivity.this, "Data GAGAL tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    } else {
                                        progressDialog = new ProgressDialog(CRUDMhsActivity.this);
                                        progressDialog.setMessage("Sabar masih proses simpan");
                                        progressDialog.show();

                                        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                        Call<DefaultResult> call = service.update_mhs(
                                                idMhs,
                                                nama.getText().toString(),
                                                nim.getText().toString(),
                                                alamat.getText().toString(),
                                                email.getText().toString(),
                                                stringImg,
                                                "72170115"
                                        );
                                        call.enqueue(new Callback<DefaultResult>() {
                                            @Override
                                            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                                                progressDialog.dismiss();

                                                Toast.makeText(CRUDMhsActivity.this, "Data tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(CRUDMhsActivity.this, RecycleViewMahasiswaActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(Call<DefaultResult> call, Throwable t) {
                                                Toast.makeText(CRUDMhsActivity.this, "Data GAGAL tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        });
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case GALERY_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    imgThumb.setImageURI(selectedImage);

                    //dptin real pathynya
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String imgDecodableString = cursor.getString(columnIndex);
                    foto.setText(imgDecodableString);
                    cursor.close();

                    //conversi ke base 64
                    Bitmap bm = BitmapFactory.decodeFile(imgDecodableString);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();

                    stringImg = Base64.encodeToString(b, Base64.DEFAULT);
            }
        }
    }
    private void choosePhoto() {
        //----------------------------untuk permission buka galery--> bisa juga ditaruh di oncrete----------------------------------
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
               /* && ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED*/) {
            // read utk baca dari hp
            //write utk ambil dari luar

            //ini beri permmisionnya kalau blom ada
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_STORAGE);

        } else {
            openGallery();
        }
    }

    //----------------------------Buka galery--------------------------------------------
    public void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg"}; // filter hanya file jpeg yang ada
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        startActivityForResult(intent, GALERY_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_REQUEST_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permession granted
                }
                break;
        }
    }


}
