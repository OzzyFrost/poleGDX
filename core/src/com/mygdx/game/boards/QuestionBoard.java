package com.mygdx.game.boards;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.Letter;
import com.mygdx.game.Textures;

public class QuestionBoard {
    Letter[] question;
    int questionLength = 0;
    float x;
    float y;
    int k;
    Letter[] scoreBoard;
    int score = 0;

    public QuestionBoard(float x, float y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
        question = new Letter[300];
    }

    public void render(Batch batch) {
        for (int i = 0; i < questionLength; i++) {
            batch.draw(Textures.getFont32(), x + (i % k) * 16, y - (i / k) * 20,
                    0, 0, 16, 16, 1, 1, 0,
                    (int) question[i].getPos().x, (int) question[i].getPos().y,
                    32, 32, false, false);
        }

    }

    public void setQuestion(String s) {
        questionLength = s.length();
        for (int i = 0; i < questionLength; i++) {
            question[i] = new Letter(s.charAt(i));
        }
    }
}
