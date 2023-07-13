package com.example.hazir_misin_proje;


import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

public class GameActivity extends AppCompatActivity {
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tehlikeden_uzaklas);
        AppConstants.initialization(this.getApplicationContext());

        gameView = new GameView(this);
        setContentView(gameView);
    }
}
