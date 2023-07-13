package com.example.hazir_misin_proje;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class AppConstants {
    static BitmapClass bitmapClass;
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_WHEN_JUMPED;
    static GameEngine gameEngine;
    static List<Pipe> pipes;

    public static void initialization(Context context) {
        setScreenSize(context);
        bitmapClass = new BitmapClass(context.getResources());
        gameEngine = new GameEngine();
        gravity = 5;
        VELOCITY_WHEN_JUMPED = -40;
        pipes = new ArrayList<>();
    }

    public static BitmapClass getBitmapClass() {
        return bitmapClass;
    }

    public static GameEngine getGameEngine() {
        return gameEngine;
    }

    private static void setScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
    }










}
