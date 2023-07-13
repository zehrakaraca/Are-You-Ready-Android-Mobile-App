package com.example.hazir_misin_proje;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Çıkmak istediğinize emin misiniz?");
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Close the application
                        finish();
                    }
                });
                builder.setNegativeButton("Hayır", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }



    public void changeActivity(View view){
        Intent intent = new Intent(MainActivity.this,cok_kapan.class);
        startActivity(intent);
    }

    public void changeActivity2(View view){
        Intent intent = new Intent(MainActivity.this,GameActivity.class);
        startActivity(intent);
    }

    public void changeActivity3(View view){
        Intent intent = new Intent(MainActivity.this,bilmece.class);
        startActivity(intent);
    }

    public void changeActivity4(View view){
        Intent intent = new Intent(MainActivity.this,afet_canta.class);
        startActivity(intent);
    }
}