package com.example.hazir_misin_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tehlikeden_uzaklas extends AppCompatActivity {
    Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tehlikeden_uzaklas);
        //AppConstants.initialization(this.getApplicationContext());

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(tehlikeden_uzaklas.this,"Oyna",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(tehlikeden_uzaklas.this,GameActivity.class);
                startActivity(intent);
            }
        });
    }
}