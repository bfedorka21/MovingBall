package com.midlandstech.williamrfedorka.movingball;

import java.util.Random;
import java.util.TimerTask;

public class BallTimerTask extends TimerTask {

    private BallGame game;
    private GameView gameView;
    private Random random;

    public BallTimerTask(GameView view) {
        gameView = view;
        game = view.getGame();
    }

    public void run() {

        random = new Random();
        if (game.ballOffScreen()) {
            game.setBallAngle(random.nextInt(180));
            game.moveBall();
        }
        else
            game.moveBall();
        gameView.postInvalidate();
    }
}
