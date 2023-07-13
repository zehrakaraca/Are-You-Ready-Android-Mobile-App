package com.example.hazir_misin_proje;

public class BackgroundImage {
    private int backgroundImageX;
    private int backgroundImageY;
    private int backgroundVelocity;

    public BackgroundImage() {
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundVelocity = 3;
    }

    public int getX() {
        return backgroundImageX;
    }

    public int getY() {
        return backgroundImageY;
    }

    public void setX(int backgroundImageX) {
        this.backgroundImageX = backgroundImageX;
    }

    public void setY(int backgroundImageY) {
        this.backgroundImageY = backgroundImageY;
    }

    public int getVelocity() {
        return backgroundVelocity;
    }
}

