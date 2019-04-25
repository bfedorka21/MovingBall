package com.midlandstech.williamrfedorka.movingball;

import android.graphics.Point;
import android.graphics.Rect;

public class BallGame {

    private Rect spaceRect;
    private int deltaTime;

    private Point ballCenter;
    private int ballRadius;
    private float ballSpeed;
    private float ballAngle;


    public BallGame(int newBallRadius, float newBallSpeed) {
        setBallSpeed(newBallSpeed);
        setBallRadius(newBallRadius);
    }

    void setBallSpeed(float newBallSpeed) {
        ballSpeed = newBallSpeed;
    }

    private void setBallRadius(int newBallRadius) {
        ballRadius = newBallRadius;
    }

    public int getBallRadius() {
        return ballRadius;
    }

    public float getBallAngle() {
        return ballAngle;
    }

    public void setBallAngle(float newBallAngle) {
        ballAngle = newBallAngle;
    }

    public float getBallSpeed() {
        return ballSpeed;
    }

    public Point getBallCenter() {
        return ballCenter;
    }

    public void setBallCenter(Point newBallCenter) {
        ballCenter = newBallCenter;
    }

    public Rect getSpaceRect() {
        return spaceRect;
    }

    public void setSpaceRect(Rect newSpaceRect) {
        spaceRect = newSpaceRect;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int newDeltaTime) {
        deltaTime = newDeltaTime;
    }
    
    public void moveBall() {
        ballCenter.x += ballSpeed * Math.cos(ballAngle) * deltaTime;
        ballCenter.y -= ballSpeed * Math.sin(ballAngle) * deltaTime;
    }
    
    public boolean ballOffScreen() {
        return ballCenter.x > spaceRect.right || ballCenter.x < spaceRect.left || ballCenter.y + ballRadius < 0 || ballCenter.y < spaceRect.top || ballCenter.y > spaceRect.bottom;
    }
}
