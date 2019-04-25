package com.midlandstech.williamrfedorka.movingball;

import android.graphics.Point;
import android.graphics.Rect;

public class BallGame {

    private Rect spaceRect;
    private int deltaTime;

    private Point ballCenter;
    private int ballRadius;
    private float ballSpeedX;
    private float ballSpeedY;
    private float ballDirectionX = 1;
    private float ballDirectionY = 1;
    private boolean ballMoving;


    public BallGame(int newBallRadius, float newBallSpeedX, float newBallSpeedY) {
        ballSpeedX = newBallSpeedX;
        ballSpeedX = newBallSpeedX;
        ballRadius = newBallRadius;

        ballMoving = true;
    }

    public Point getBallCenter() {
        return ballCenter;
    }

    public void setBallCenter(Point newBallCenter) {
        ballCenter = newBallCenter;
    }

    public void setSpaceRect(Rect newSpaceRect) {
        spaceRect = newSpaceRect;
    }

    public void setDeltaTime(int newDeltaTime) {
        deltaTime = newDeltaTime;
    }
    
    public void moveBall() {
        if (spaceRect.right - ballRadius <= ballCenter.x)
            ballDirectionX = -1;
        else if(spaceRect.left + ballRadius >= ballCenter.x)
            ballDirectionX = 1;
        if (spaceRect.top - ballRadius <= ballCenter.y)
            ballDirectionY = -1;
        else if (spaceRect.bottom + ballRadius >= ballCenter.y)
            ballDirectionY = 1;

        if (ballMoving == true) {
            ballCenter.x += ballSpeedX * ballDirectionX * deltaTime;
            ballCenter.y += ballSpeedY * ballDirectionY * deltaTime;
        }
    }

    public float getBallRadius() {
        return ballRadius;
    }

    public void setBallMoving(boolean newBallMoving) {
        ballMoving = newBallMoving;
    }
}
