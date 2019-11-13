package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        
        super.onCreate(savedInstanceState);

//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        this.getSupportActionBar().hide();



      /*  final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000L);*/

//        Preference login
        SharedPreferences prefs = SplashScreenActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin=prefs.getString("isLogin",null);
        if(statusLogin!=null){
            if(statusLogin.equals("Admin")){
                Intent intent = new Intent(SplashScreenActivity.this, MenuDosenAdminActivity.class);
                startActivity(intent);
            }else if(statusLogin.equals("Mhs")){
                Intent intent = new Intent(SplashScreenActivity.this,MenuDosenActivity.class);
                startActivity(intent);
            }
        }
       else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }, 3000L);
        }
    }
}
