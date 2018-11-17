package com.mygdx.game.boards;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.Textures;

public class TVHost {
    private float x;
    private float y;
    private int timeShow = 240;
    private int speakIndex = 15;

    public TVHost(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void render(Batch batch) {
        if (timeShow > 0) {
            batch.draw(Textures.getYakubovich(), x, y);
            batch.draw(Textures.getWords(), x-210, y+100,0,0,256,128,
                    1,1,0,(speakIndex%4) * 256 ,(7-speakIndex/4) *128 ,
                    256,128,false,false);
        }
    }

    public void update() {
        if (timeShow > 0) {
            timeShow--;
        }
    }

    public void show(int timeShow, int speakIndex) {
        this.timeShow = timeShow;
        this.speakIndex = speakIndex;
    }
}
