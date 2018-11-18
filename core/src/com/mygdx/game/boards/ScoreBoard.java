package com.mygdx.game.boards;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.Letter;
import com.mygdx.game.Textures;

public class ScoreBoard {
    private Letter[] scoreText;
    private int scoreTextLength = 0;
    private float x;
    private float y;
    private int score = 0;

    public ScoreBoard(float x, float y) {
        this.x = x;
        this.y = y;
        scoreText = new Letter[30];
        setScoreText("СЧЕТ: 0");
    }

    public void render(Batch batch) {
        for (int i = 0; i < scoreTextLength; i++) {
            batch.draw(Textures.getFont32(), x + i * 20, y,
                    0, 0, 20, 32, 1, 1, 0,
                    (int) scoreText[i].getPos().x, (int) scoreText[i].getPos().y,
                    32, 32, false, false);
        }
    }

    public void setScoreText(String s) {
        scoreTextLength = s.length();
        for (int i = 0; i < scoreTextLength; i++) {
            scoreText[i] = new Letter(s.charAt(i));
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void calculateScore(int barabanIndex, int lettersCount) {
        //    {"10","15","30","Ш","5","x2","50","Б","0","+","20","90"};
        switch (barabanIndex) {
            case 0: {setScore(10*lettersCount + getScore());break; }
            case 1: {setScore(15*lettersCount+ getScore());break; }
            case 2: {setScore(30*lettersCount+ getScore());break; }
            case 3: {break; }
            case 4: {setScore(5*lettersCount+ getScore());break; }
            case 5: {setScore(getScore()*2);break; }
            case 6: {setScore(50*lettersCount+ getScore());break; }
            case 7: {setScore(0);break; }
            case 8: {break; }
            case 9: {break; }
            case 10: {setScore(20*lettersCount+ getScore());break; }
            case 11: {setScore(90*lettersCount+ getScore());break; }
        }
    }
}
