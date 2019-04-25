package com.midlandstech.williamrfedorka.movingball;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;
    private BallGame game;
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        int statusBarHeight = 0;
        int statusBarId = res.getIdentifier("status_bar_height", "dimen", "android");
        if(statusBarId > 0)
            statusBarHeight = res.getDimensionPixelSize(statusBarId);

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        gameView = new GameView(this, size.x, size.y - statusBarHeight);
        setContentView(gameView);

        Timer gameTimer = new Timer();
        gameTimer.schedule(new BallTimerTask(gameView), 0, GameView.DELTA_TIME);

        game = gameView.getGame();
        TouchHandler th = new TouchHandler();
        detector = new GestureDetector(this, th);
        detector.setOnDoubleTapListener(th);
    }

    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener {

        public boolean onDoubleTapEvent(MotionEvent event) {
            Log.e("MainActivity", "double tap");
            game.setBallMoving(true);
            return true;
        }

        public void onLongPress(MotionEvent event) {
            Log.e("MainActivity", "long press");
            game.setBallMoving(false);
        }
    }
}
