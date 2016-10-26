package com.kd.kd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kd.kd.main.MaterialMain;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
    }
    public void login(View v){
        Intent in=new Intent(LogActivity.this, MaterialMain.class);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        startActivity(in);
        finish();
    }
    public void regin(View v){
        Toast.makeText(LogActivity.this,"regin",Toast.LENGTH_LONG).show();
    }
}
