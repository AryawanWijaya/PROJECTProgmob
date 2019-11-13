package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        Button btnClient = findViewById(R.id.btnClient);
        final EditText email = findViewById(R.id.txtEmail);
        EditText pass = findViewById(R.id.txtPassword);
        this.getSupportActionBar().hide();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(MainActivity.this, MenuDosenAdminActivity.class);
                startActivity(intent);*/
                SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
                String statusLogin = prefs.getString("isLogin",null);
                SharedPreferences.Editor edit = prefs.edit();

                if(email.getText().toString().contains("@staff.ukdw.ac.id")){
                    edit.putString("isLogin","Admin");
                    edit.commit();
                    Intent intent = new Intent(MainActivity.this, MenuDosenAdminActivity.class);
                    startActivity(intent);

                }else if(email.getText().toString().contains("@si.ukdw.ac.id")){
                    edit.putString("isLogin","Mhs");
                    edit.commit();
                    Intent intent = new Intent(MainActivity.this,MenuDosenActivity.class);
                    startActivity(intent);

                }
            }
        });

        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuDosenActivity.class);
                startActivity(intent);
            }
        });



    }
}
