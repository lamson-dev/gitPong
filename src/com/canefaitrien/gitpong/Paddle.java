package com.canefaitrien.gitpong;

import android.graphics.Point;

/**
 * Paddle
 * 
 * @author DX
 * 
 */
public class Paddle implements IPaddleModel {
	private Point position;
	private int bitmapId;
	private double width;
	private double vx;
	private int targx;

	public Paddle() {
		bitmapId = R.drawable.paddle;
		position = new Point();
		vx = 10;
		// test
		position.set(50, 950);

	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public Point getPosition() {
		return position;
	}

	public void setX(int newx) {
		position.x = newx;
	}

	public void setTargx(int newx) {
		targx = newx;
	}

	public void setPosition(int x, int y) {
		position.set(x, y);
	}

	public double getWidth() {
		return width;
	}

	public double getSpeed() {
		return vx;
	}

	public int getTargx() {
		return targx;
	}

	public int getBitmapId() {
		return bitmapId;
	}

	public void setWidth(double value) {
		width = value;
	}
}
