package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Baraban {
    private float centerX;
    private float centerY;
    private float radius;
    private double speed;
    private float angle;
    private boolean stopped = false;

    public Baraban(float centerX, float centerY, float radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void render(Batch batch) {
        batch.draw(Textures.getBaraban(), centerX - radius, centerY - radius, radius, radius,
                radius * 2, radius * 2, 1, 1, angle, 0, 0,
                512, 512, false, false);
        batch.draw(Textures.getStrelka(), centerX, centerY);
    }

    public void update() {
        if (speed > 0) {
            speed--;
            setStopped(false);
        }
        if ((Math.abs(speed) < 2) && (speed != 0)) {
            speed = 0;
            setStopped(true);
        }
        angle += speed / 60;
        angle %= 360;
    }

    public void twist(float speed) {
        this.speed = speed * (Math.random() + 0.5);
    }

    public boolean isPress(float x, float y) {
        double r = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return r <= radius;
    }

    private void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        if (stopped) {
            setStopped(false);
            return true;
        }
        return false;
    }

    public int getIndex() {
        return (int) Math.floor((angle + 15) / 30) % 12;
    }


}

