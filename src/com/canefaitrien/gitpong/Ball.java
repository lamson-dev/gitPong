package com.canefaitrien.gitpong;

import android.graphics.Rect;
import android.util.Log;

public class Ball implements IBallModel {
	private final String TAG = "Ball";

	private float x;
	private float y;
	private float vx;
	private float vy;
	private int width;
	private int height;
	private float defx, defy, defvx, defvy;
	private Rect rect;

	public Ball() {
		defx = 400;
		defy = 500;
		defvx = (float) 5.5;
		defvy = 5;
		rect = new Rect((int) (x - width / 2), (int) (y - height / 2),
				(int) (x + width / 2), (int) (y + height / 2));
		reset();
	}

	public boolean hitPaddle(IPaddleModel pad) {
		if(pad.getRect().intersect(rect)){
			return true;
		}
		return false;
	}
	public boolean hitEdge(int canvasWidth) {

		if (x <= 0 || x >= canvasWidth - width / 2) {
			Log.d(TAG, "ball hit edge");
			return true;
		}
		return false;
	}

	public boolean hitEnd(int canvasHeight) {
		if (y <= 0) {
			return true;
		} else if (y >= canvasHeight - height / 2) {
			return true;
		}
		return false;
	}

	//
	public void reset(){
		Log.d(TAG, "reseting ball");
		x = defx;
		y = defy;
		vx = defvx;
		vy = defvy;
	}
	public Rect getRect(){
		return rect;
	}
	public void updateX() {
		x += vx;
	}

	public void updateY() {
		y += vy;
	}

	public float getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
