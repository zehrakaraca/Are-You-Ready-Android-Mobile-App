package com.example.hazir_misin_proje;

import static com.example.hazir_misin_proje.AppConstants.gameEngine;
//import static com.example.hazir_misin_proje.AppConstants.getScore;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEngine {
    private BackgroundImage backgroundImage;
    public Hero hero;
    private List<Pipe> pipes;
    private long lastPipeTime;
    public int gameState;

    private static int score = 0;




    public GameEngine() {
        backgroundImage = new BackgroundImage();
        hero = new Hero();
        pipes = new ArrayList<>();
        lastPipeTime = System.currentTimeMillis();
        gameState = 0;
    }

    public static void incrementScore() {
        score+=1;
    }

    public static void resetScore() {
        score = 0;
    }

    public static int getScore() {
        return score;
    }


    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());

        if (backgroundImage.getX() < -AppConstants.getBitmapClass().getBackgroundWidth()) {
            backgroundImage.setX(0);
        }

        canvas.drawBitmap(AppConstants.getBitmapClass().getBackground_game(),
                backgroundImage.getX(), backgroundImage.getY(), null);

        if (backgroundImage.getX() < (AppConstants.getBitmapClass().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapClass().getBackground_game(),
                    backgroundImage.getX() + AppConstants.getBitmapClass().getBackgroundWidth(),
                    backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawHero(Canvas canvas) {
        if (gameState == 1) {
            if (hero.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapClass().getHeroHeight())
                    || hero.getVelocity() < 0) {
                hero.setVelocity(hero.getVelocity() + AppConstants.gravity);
                hero.setY(hero.getY() + hero.getVelocity());
            }else {
                gameState = 2;
                reset();
            }
        }

        int currentFrame = hero.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapClass().getHero(currentFrame),
                hero.getX(), hero.getY(), null);
        currentFrame++;
        if (currentFrame > Hero.maxFrame) {
            currentFrame = 0;
        }
        hero.setCurrentFrame(currentFrame);
    }


    public void updateAndDrawPipes(Canvas canvas) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPipeTime >= 1500) {
            int pipeGap = 400; // Distance between upper and lower pipes
            int pipeWidth = AppConstants.getBitmapClass().getPipeWidth();
            int pipeHeight = AppConstants.getBitmapClass().getPipeHeight();
            int minY = pipeGap / 2;
            int maxY = AppConstants.SCREEN_HEIGHT - pipeGap / 2 - pipeHeight;

            int randomY = minY + (int) (Math.random() * (maxY - minY + 1));
            int pipeX = AppConstants.SCREEN_WIDTH + 50;
            Pipe upperPipe = new Pipe(pipeWidth, pipeHeight, pipeX, randomY - pipeHeight, 8);
            Pipe lowerPipe = new Pipe(pipeWidth, pipeHeight, pipeX, randomY + pipeGap, 8);

            pipes.add(upperPipe);
            pipes.add(lowerPipe);

            lastPipeTime = currentTime;
        }

        Iterator<Pipe> iterator = pipes.iterator();
        while (iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.update();

            if (pipe.getX() + pipe.getWidth() < -100) {
                iterator.remove();
            } else {
                canvas.drawBitmap(AppConstants.getBitmapClass().getPipe(),
                        pipe.getX(), pipe.getY(), null);
            }

        }

        if (checkCollision()) {
            gameState = 2; // Game over state
            reset();
        }


        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(50);
        canvas.drawText("Skor: " + getScore(), 100, 100, scorePaint);

        updateScore();
    }

    public boolean checkCollision() {
        int heroX = hero.getX();
        int heroY = hero.getY();
        int heroWidth = hero.getWidth();
        int heroHeight = hero.getHeight();

        for (Pipe pipe : pipes) {
            int pipeX = pipe.getX();
            int pipeY = pipe.getY();
            int pipeWidth = pipe.getWidth();
            int pipeHeight = pipe.getHeight();

            // Check for collision between hero and pipes
            if (heroX < pipeX + pipeWidth &&
                    heroX + heroWidth > pipeX &&
                    heroY < pipeY + pipeHeight &&
                    heroY + heroHeight > pipeY) {
                // Collision occurred
                return true;
            }
        }

        return false;
    }

    public void updateScore() {
        int currentScore = getScore();
        boolean incrementScore = false;
        for (Pipe pipe : pipes) {
            if (pipe.getX() + pipe.getWidth() < hero.getX() && !pipe.isCounted()) {
                pipe.setCounted(true);
                incrementScore = true;
            }
        }
        if (incrementScore) {
            incrementScore(); // Increase the score by 1
        }
    }






    public void reset() {
        backgroundImage.setX(0);
        hero.reset();
        pipes.clear();
        lastPipeTime = System.currentTimeMillis();
        gameState = 0;
        resetScore();
    }
}

