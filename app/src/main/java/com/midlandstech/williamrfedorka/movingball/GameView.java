package com.midlandstech.williamrfedorka.movingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

public class GameView extends View {

    public static int DELTA_TIME = 100;

    private Paint paint;
    private BallGame game;

    public GameView(Context context, int width, int height) {
        super(context);
        
        game = new BallGame(150, .03f);
        game.setBallSpeed(width * .00003f);
        game.setDeltaTime(DELTA_TIME);
        game.setSpaceRect(new Rect(0, 0, width, height));
        game.setBallCenter(new Point(750,950));
        
        paint = new Paint();
        paint.setColor(0xFF000000);
        paint.setAntiAlias(true);
        paint.setStrokeWidth( game.getBallRadius( ) );
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(game.getBallCenter().x, game.getBallCenter().y, game.getBallRadius(), paint);
    }

    public BallGame getGame() {
        return game;
    }
}
