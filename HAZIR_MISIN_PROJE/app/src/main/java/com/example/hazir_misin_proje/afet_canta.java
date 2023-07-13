package com.example.hazir_misin_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class afet_canta extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
    int score;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    boolean isGameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afet_canta);

        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[] {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        hideImages();


        score = 0;

        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (!isGameOver) {
                timeText.setText("Süre: "+ millisUntilFinished/1000); }

            }

            @Override
            public void onFinish() {
                timeText.setText("Süre bitti");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Toast.makeText(afet_canta.this,"Oyun bitti",Toast.LENGTH_LONG).show();

            }
        }.start();
    }



    public void increaseScore(View view) {
        ImageView clickedImage = (ImageView) view;
        int id = clickedImage.getId();

        if (id == R.id.imageView6 || id == R.id.imageView7 || id == R.id.imageView8) {
            // Game over logic
            timeText.setText("Süre : 0");
            handler.removeCallbacks(runnable);
            for (ImageView image : imageArray) {
                image.setVisibility(View.INVISIBLE);
            }

            Toast.makeText(afet_canta.this, "Oyun bitti", Toast.LENGTH_LONG).show();
            isGameOver = true;
        } else {
            score++;
            scoreText.setText("Skor: " + score);
        }

        if (score < 0) {
            // Stop the countdown if the score goes below 0
            handler.removeCallbacks(runnable);
        }
    }


    public void hideImages() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (!isGameOver) {
                    for (ImageView image : imageArray) {
                        image.setVisibility(View.INVISIBLE);
                    }
                    Random random = new Random();
                    int i = random.nextInt(9);
                    imageArray[i].setVisibility(View.VISIBLE);

                    if (timeText.getText().toString().equals("Süre: 0")) {
                        handler.removeCallbacks(this);  // Stop the countdown if time is already 0
                    } else {
                        handler.postDelayed(this, 1000);
                    }
                }
            }
        };

        handler.post(runnable);
    }



}