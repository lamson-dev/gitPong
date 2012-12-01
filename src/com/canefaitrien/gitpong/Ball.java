package com.canefaitrien.gitpong;

import android.util.Log;

public class Ball implements IBallModel {
	private final String TAG = "Ball";

	private float x;
	private float y;
	private float vx;
	private float vy;
	private int width;
	private int height;

	public Ball() {
		vx = 5;
		vy = 5;
		x = 50;
		y = 50;
	}

	public boolean hitPaddle(float padX, float padY, float padWidth) {
		if ((y + height) >= padY) {
			Log.d(TAG, "y is greater than padY");
			// if (x >= (padX + padWidth / 2) && x <= (padX + padWidth / 2)) {
			if (x >= 0 && x <= padX) {
				Log.d(TAG, "ball hit paddle padX=" + padX + " padY=" + padY
						+ " " + padWidth);
				return true;
			}
		}
		return false;
	}

	public boolean hitEdge(int canvasWidth) {

		if (x <= 0 || x >= canvasWidth - width) {
			Log.d(TAG, "ball hit edge");
			return true;
		}
		return false;
	}

	public boolean hitEnd(int canvasHeight) {

		if (y <= 0 || y >= canvasHeight - height) {
			Log.d(TAG, "ball hit end");
			return true;
		}
		return false;
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
