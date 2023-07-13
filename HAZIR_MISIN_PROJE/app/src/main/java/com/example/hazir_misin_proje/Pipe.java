package com.example.hazir_misin_proje;

import android.graphics.Rect;

public class Pipe {
    private int width, height;
    private int x, y;
    private int speed;

    public Pipe(int width, int height, int x, int y, int speed) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update() {
        x -= speed;
    }

    public Rect getBounds() {
        return new Rect(x, y, x + width, y + height);
    }

    private boolean passed;

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    private boolean counted;

    public boolean isCounted() {
        return counted;
    }

    public void setCounted(boolean counted) {
        this.counted = counted;
    }
}

