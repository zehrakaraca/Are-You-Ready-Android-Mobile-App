package com.example.hazir_misin_proje;

public class Hero {
    private int heroX, heroY, currentFrame, velocity;
    public static int maxFrame;

    public Hero() {
        heroX = AppConstants.SCREEN_WIDTH / 2 - AppConstants.getBitmapClass().getHeroWidth() / 2;
        heroY = AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapClass().getHeroHeight() / 2;
        currentFrame = 0;
        maxFrame = 3;
        velocity = 0;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getX() {
        return heroX;
    }

    public int getY() {
        return heroY;
    }

    public void setX(int heroX) {
        this.heroX = heroX;
    }

    public void setY(int heroY) {
        this.heroY = heroY;
    }

    public int getMaxFrame() {
        return maxFrame;
    }

    public void reset() {
        heroX = AppConstants.SCREEN_WIDTH / 2 - AppConstants.getBitmapClass().getHeroWidth() / 2;
        heroY = AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapClass().getHeroHeight() / 2;
        currentFrame = 0;
        velocity = 0;
    }

    public int getWidth() {
        return AppConstants.getBitmapClass().getHeroWidth();
    }

    public int getHeight() {
        return AppConstants.getBitmapClass().getHeroHeight();
    }
}

