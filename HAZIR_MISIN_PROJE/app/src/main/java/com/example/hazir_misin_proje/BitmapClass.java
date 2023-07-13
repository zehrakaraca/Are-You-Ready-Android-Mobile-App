package com.example.hazir_misin_proje;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapClass {
    private Bitmap background_game;
    private Bitmap[] hero;
    private Bitmap pipe;

    public BitmapClass(Resources resources){
        background_game = BitmapFactory.decodeResource(resources, R.drawable.ev);
        background_game = scaleImage(background_game);

        hero = new Bitmap[4];
        hero[0] = BitmapFactory.decodeResource(resources, R.drawable.kahraman2);
        hero[1] = BitmapFactory.decodeResource(resources, R.drawable.kahraman2);
        hero[2] = BitmapFactory.decodeResource(resources, R.drawable.kahraman2);
        hero[3] = BitmapFactory.decodeResource(resources, R.drawable.kahraman2);

        pipe = BitmapFactory.decodeResource(resources, R.drawable.kitaplik);
    }

    public Bitmap getHero(int frame){
        return hero[frame];
    }

    public int getHeroWidth(){
        return hero[0].getWidth();
    }

    public int getHeroHeight(){
        return hero[0].getHeight();
    }

    public Bitmap getBackground_game(){
        return background_game;
    }

    public int getBackgroundWidth(){
        return background_game.getWidth();
    }

    public int getBackgroundHeight(){
        return background_game.getHeight();
    }

    public Bitmap getPipe() {
        return pipe;
    }

    public int getPipeWidth() {
        return pipe.getWidth();
    }

    public int getPipeHeight() {
        return pipe.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / (float) getBackgroundHeight();
        int backgroundScaleWidth = (int) (widthHeightRatio * AppConstants.SCREEN_HEIGHT);
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
