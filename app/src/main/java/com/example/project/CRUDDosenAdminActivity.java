package com.example.project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import com.example.project.Model.DefaultResult;
import com.example.project.Network.GetDataService;
import com.example.project.Network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class CRUDDosenAdminActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 58; // bebas asal nanti dipakai terus di activity yang laen, utk cek permissionnya
    private static final int PERMISSION_REQUEST_STORAGE = 58;
    private static final int    GALERY_REQUEST_CODE =58;
    private Uri uri;
    ProgressDialog progressDialog;
    private EditText namaDosen,nidnDosen,alamatDosen,emailDosen,gelarDosen,fotoDosen;
    private String txtNama,txtNidn,txtAlamat,txtEmail,txtGelar;
    private Button btnSimpan,btnBrowse;
    private ImageView imgThumb;
    private   String encodedImageData;
    private String  stringImg;
    Boolean isValid=true;
    Boolean isUpdate=false;
    String idDosen;
    void checkUpdate(){
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return ;
        }
        isUpdate=extras.getBoolean("is_update");
        idDosen=extras.getString("id_dosen");
        namaDosen.setText(extras.getString("nama_dosen"));
        nidnDosen.setText(extras.getString("nidn"));
        alamatDosen.setText(extras.getString("alamat"));
        emailDosen.setText(extras.getString("email"));
        gelarDosen.setText(extras.getString("gelar"));
        fotoDosen.setText(extras.getString("foto"));
        Picasso.with(this).
                load("https://kpsi.fti.ukdw.ac.id/progmob/"+extras.get("foto"))
                .into(imgThumb);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_dosen_admin);
        this.setTitle("SI KRS - ADMIN - CRUD Dosen");
        namaDosen = findViewById(R.id.edtxtNamaDosenCRUD);
        nidnDosen = findViewById(R.id.edtxtNIDNDosenCRUD);
        alamatDosen = findViewById(R.id.edtxtAlamatDosenCRUD);
        emailDosen = findViewById(R.id.edtxtEmailDosenCRUD);
        gelarDosen = findViewById(R.id.edtxtGelarDosenCRUD);
        fotoDosen = findViewById(R.id.edtxtFotoDosenCRUD);
        imgThumb=findViewById(R.id.imgDosenView);

        checkUpdate();
        btnSimpan = findViewById(R.id.btnSimpanDosenCRUD);
        btnBrowse = findViewById(R.id.btnBrowseFotoCRUD);

        //create and update data
        if (isUpdate) {
            btnSimpan.setText("Update");
        }
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiInput();
                if(isValid){
                    AlertDialog.Builder builder = new AlertDialog.Builder(CRUDDosenAdminActivity.this);
                    builder.setMessage("Apakah anda yakin akan menyimpan data? ")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(CRUDDosenAdminActivity.this, "Data tidak tersimpan",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (!isUpdate) {

                                        progressDialog = new ProgressDialog(CRUDDosenAdminActivity.this);
                                        progressDialog.setMessage("Sabar ya masih nyimpan data");
                                        progressDialog.show();

                                        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                        retrofit2.Call<DefaultResult> call = service.insert_dosen_foto(
                                                namaDosen.getText().toString(),
                                                nidnDosen.getText().toString(),
                                                alamatDosen.getText().toString(),
                                                emailDosen.getText().toString(),
                                                gelarDosen.getText().toString(),
                                                stringImg,
//                                            encodedImageData,
                                                "72170115"
                                        );
                                        call.enqueue(new Callback<DefaultResult>() {
                                            @Override
                                            public void onResponse(retrofit2.Call<DefaultResult> call, Response<DefaultResult> response) {
                                                progressDialog.dismiss();
                                                Toast.makeText(CRUDDosenAdminActivity.this, "Data tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(CRUDDosenAdminActivity.this, RecycleViewDosenActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(retrofit2.Call<DefaultResult> call, Throwable t) {
                                                Toast.makeText(CRUDDosenAdminActivity.this, "Data TIDAK tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                    }else {

                                        progressDialog = new ProgressDialog(CRUDDosenAdminActivity.this);
                                        progressDialog.setMessage("Sabar ya masih nyimpan data");
                                        progressDialog.show();

                                        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                                        retrofit2.Call<DefaultResult> call = service.update_dosen_foto(
                                                idDosen,
                                                namaDosen.getText().toString(),
                                                nidnDosen.getText().toString(),
                                                alamatDosen.getText().toString(),
                                                emailDosen.getText().toString(),
                                                gelarDosen.getText().toString(),
                                                stringImg,
//                                            encodedImageData,
                                                "72170115"
                                        );
                                        call.enqueue(new Callback<DefaultResult>() {
                                            @Override
                                            public void onResponse(retrofit2.Call<DefaultResult> call, Response<DefaultResult> response) {
                                                progressDialog.dismiss();
                                                Toast.makeText(CRUDDosenAdminActivity.this, "Data tersimpan",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(CRUDDosenAdminActivity.this, RecycleViewDosenActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(retrofit2.Call<DefaultResult> call, Throwable t) {
                                                Toast.makeText(CRUDDosenAdminActivity.this, "Data TIDAK tersimpan",
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


//----------------------------btn cari foto--------------------------------------------
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
    }
//--------------------------------------metode ary------------------------------------------
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if(data != null) {
                uri = data.getData();

                imgThumb.setImageURI(uri);

            }
        }
        if (uri != null) {

            try {
                String path = getRealPathFromURI(uri);
                Bitmap bitmap= BitmapFactory.decodeFile(path);
                encodedImageData=getEncoded64ImageStringFromBitmap(bitmap);
                fotoDosen.setText(encodedImageData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

   public boolean validasiInput(){
       txtNama=namaDosen.getText().toString();
       txtNidn=nidnDosen.getText().toString();
       txtAlamat=alamatDosen.getText().toString();
       txtEmail=emailDosen.getText().toString();
       txtGelar=gelarDosen.getText().toString();

       if(TextUtils.isEmpty(txtNama)){
           namaDosen.setError("Nama Tidak Boleh Kosong");
           isValid=false;
       }else
       {
           isValid=true;
       }
       if(TextUtils.isEmpty(txtNidn)){
           nidnDosen.setError("Nidn Tidak Boleh Kosong");
           isValid=false;
       }else
       {
           isValid=true;
       }
       if(TextUtils.isEmpty(txtAlamat)){
           alamatDosen.setError("Alamat Tidak Boleh Kosong");
           isValid=false;
       }else
       {
           isValid=true;
       }
       if (TextUtils.isEmpty(txtEmail)){
           emailDosen.setError("Email Tidak Boleh Kosong");
           isValid=false;
       }else
       {
           isValid=true;
       }
       if(TextUtils.isEmpty(txtGelar)){
           gelarDosen.setError("Gelar Tidak Boleh Kosong");
           isValid=false;
       }else
       {
           isValid=true;
       }

       return isValid;
   }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            switch (requestCode){
                case GALERY_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    imgThumb.setImageURI(selectedImage);

                    //dptin real pathynya
                    String [] filePathColumn ={MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn,null,null,null);
                    cursor.moveToFirst();
                    int columnIndex= cursor.getColumnIndex(filePathColumn[0]);
                    String imgDecodableString = cursor.getString(columnIndex);
                    fotoDosen.setText(imgDecodableString);
                    cursor.close();

                    //conversi ke base 64
                    Bitmap bm = BitmapFactory.decodeFile(imgDecodableString);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte [] b = baos.toByteArray();

                    stringImg=Base64.encodeToString(b,Base64.DEFAULT);
            }
        }
    }

    //----------------------------metode untuk converd uri ke string path--------------------------------------------
    //------------------------------klo pake metode pak argo ndak kepake ini ---------------------------------------
    @SuppressLint("ObsoleteSdkInt")
    private String getRealPathFromURI(Uri contentURI) {

        String realPath="";
// SDK < API11
        if (Build.VERSION.SDK_INT < 11) {
            String[] proj = { MediaStore.Images.Media.DATA };
            @SuppressLint("Recycle") Cursor cursor = getContentResolver().query(uri, proj, null, null, null);
            int column_index = 0;
            String result="";
            if (cursor != null) {
                column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                realPath=cursor.getString(column_index);
            }
        }
        // SDK >= 11 && SDK < 19
        else if (Build.VERSION.SDK_INT < 19){
            String[] proj = { MediaStore.Images.Media.DATA };
            CursorLoader cursorLoader = new CursorLoader(this, uri, proj, null, null, null);
            Cursor cursor = cursorLoader.loadInBackground();
            if(cursor != null){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                realPath = cursor.getString(column_index);
            }
        }
        // SDK > 19 (Android 4.4)
        else{
            String wholeID = DocumentsContract.getDocumentId(uri);
            // Split at colon, use second item in the array
            String id = wholeID.split(":")[1];
            String[] column = { MediaStore.Images.Media.DATA };
            // where id is equal to
            String sel = MediaStore.Images.Media._ID + "=?";
            Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column, sel, new String[]{ id }, null);
            int columnIndex = 0;
            if (cursor != null) {
                columnIndex = cursor.getColumnIndex(column[0]);
                if (cursor.moveToFirst()) {
                    realPath = cursor.getString(columnIndex);
                }
                cursor.close();
            }
        }
        return realPath;
    }
    //----------------------------metode untuk converd gambar--------------------------------------------
    //------------------------------klo pake metode pak argo ndak kepake ini -----------------------------
    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);

        return imgString;
    }

    //----------------------------untuk pilih gambar----------------------------------
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

        }else{
            openGallery();
        }
    }
    //----------------------------Buka galery--------------------------------------------
    public void openGallery(){
        //------------------------------klo pake metode pak argo ndak kepake ini -----------------
       /* Intent intent = new Intent();
        intent.setType("image/*"); //filter hanya buka explore galery
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);*/

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes={"image/jpeg"}; // filter hanya file jpeg yang ada
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        startActivityForResult(intent,GALERY_REQUEST_CODE);
    }


    //------------------buat tangkap apa yang harus dilakukan setelah kita allow akses/ cek permmision yang ada di metodchoose foto-----
    // cth kegunaan if granted open galery --> dalam kasus ini tidak dipakai
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_REQUEST_STORAGE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //permession granted
                }
                break;
        }
    }
}
