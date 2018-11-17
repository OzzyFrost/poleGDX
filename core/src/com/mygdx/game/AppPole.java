package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.boards.*;

public class AppPole extends ApplicationAdapter {
    SpriteBatch batch;
    Baraban baraban;
    Background background;
    LettersBoard lettersBoard;
    Board board;
    QuestionBoard questionBoard;
    ScoreBoard scoreBoard;
    TVHost tvHost;
    private Viewport viewport;
    private Vector2 coord;

    @Override
    public void create() {
        coord = new Vector2();
        viewport = new FitViewport(800, 600);
        batch = new SpriteBatch();
        baraban = new Baraban(200, 200, 160);
        background = new Background();
        lettersBoard = new LettersBoard(535, 10, 8);
        board = new Board(50, 510);
        board.setHiddenWord(Task.getAnswer(0));
        questionBoard = new QuestionBoard(400, 480, 24);
        questionBoard.setQuestion(Task.getQuestion(0));
        scoreBoard = new ScoreBoard(400, 550);
        tvHost = new TVHost(600,200);
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        baraban.render(batch);
        lettersBoard.render(batch);
        board.render(batch);
        questionBoard.render(batch);
        scoreBoard.render(batch);
        tvHost.render(batch);
        batch.end();
    }

    public void update() {
        baraban.update();
        tvHost.update();
        if (Gdx.input.justTouched()) {
            System.out.println(getClickCoord().x + " " + getClickCoord().y);

            if (baraban.isPress(getClickCoord().x, getClickCoord().y)) {
                baraban.twist(300);
            }

            if (lettersBoard.isPress(getClickCoord()) && (lettersBoard.isEnable())) {
                lettersBoard.setEnable(false);
//                System.out.println(lettersBoard.getIndex(getClickCoord()));
                int index = lettersBoard.getIndex(getClickCoord());
                lettersBoard.openLetter(index);
                scoreBoard.calculateScore(baraban.getIndex(), board.numberOfChar(Letter.getChars().charAt(index)));
                scoreBoard.setScoreText("СЧЕТ: " + scoreBoard.getScore());
                board.openChar(Letter.getChars().charAt(index));


            }
        }

        if (baraban.isStopped()) {
            lettersBoard.setEnable(true);
            tvHost.show(180, baraban.getIndex());
            System.out.println("baraban stopped ");
            System.out.println(baraban.getIndex());
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
        getViewport().apply();
    }

    public Vector2 getClickCoord() {
//        return coord.set(Gdx.input.getX(), Gdx.input.getY())
        getViewport().unproject(coord.set(Gdx.input.getX(), Gdx.input.getY()));
        return coord;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
