package com.midlandstech.williamrfedorka.movingball;

import java.util.TimerTask;

public class BallTimerTask extends TimerTask {

    private BallGame game;
    private GameView gameView;

    public BallTimerTask(GameView view) {
        gameView = view;
        game = view.getGame();
    }

    public void run() {
        if (game.ballOffScreen()) {
            game.setBallAngle(180 - game.getBallAngle());
            game.moveBall();
        }
        else
            game.moveBall();
        gameView.postInvalidate();
    }
}
