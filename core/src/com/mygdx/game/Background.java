package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Background {

    public void render(Batch batch) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                batch.draw(Textures.getBackground(), i * 64, j * 64);
            }
        }
    }
}
