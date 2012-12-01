package com.canefaitrien.gitpong;

import android.graphics.Rect;

/**
 * Paddle
 * 
 * @author DX
 * 
 */
public class Paddle implements IPaddleModel {
	private float x, y, targetx;
	private int bitmapId;
	private int width, height; // width
	private float vx; // x velocity
	private Rect rect;

	public Paddle() {
		bitmapId = R.drawable.paddle;
		vx = 10;
		width = 200;
		height = 40;
		// rect
		rect = new Rect((int) (x - width / 2), (int) (y - height / 2),
				(int) (x + width / 2), (int) (y + height / 2));
		// test position
		x = 700;
		y = 900;
		targetx = x;
		//
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float newx) {
		x = newx;
	}

	public void setY(float newy) {
		y = newy;
	}

	public float getTargetx() {
		return targetx;
	}

	public void setTargetx(float newx) {
		targetx = newx;
	}

	// target y goes here
	public void setPosition(int newx, int newy) {
		x = newx;
		y = newy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int value) {
		width = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int value) {
		height = value;
	}

	public float getSpeed() {
		return vx;
	}

	public Rect getRect(){
		return rect;
	}
	public int getBitmapId() {
		return bitmapId;
	}
}
