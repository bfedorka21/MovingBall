package com.midlandstech.williamrfedorka.movingball;

import java.util.Random;
import java.util.TimerTask;

public class BallTimerTask extends TimerTask {

    private BallGame game;
    private GameView gameView;
    public BallTimerTask(GameView view) {
        gameView = view;
        game = view.getGame();
    }

    public void run() {
        game.moveBall();
        gameView.postInvalidate();
    }
}
