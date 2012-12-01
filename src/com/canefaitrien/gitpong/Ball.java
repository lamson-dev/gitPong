package com.canefaitrien.gitpong;

import android.graphics.Point;

public class Ball {
	private Point position;
	private int bitmapId;
	private float vx;
	private float vy;
	private int width;
	private int height;

	public Ball(int id) {
		setBitmapId(id);
		setVx(5);
		setVy(5);
		setPosition(new Point(50, 50));
	}

	/**
	 * checks if ball hit a paddle
	 * 
	 * @return
	 */
	public boolean hitPaddle() {
		return false;
	}

	/**
	 * Checks is the ball is hitting a wall (edge of screen)
	 * 
	 * @return
	 */
	public boolean hitEdge(int canvasWidth) {
		if (position.x <= 0 || position.x >= canvasWidth - width) {
			return true;
		}
		return false;
	}

	/**
	 * checks if ball has passed a paddle
	 * 
	 * @return
	 */
	public boolean hitEnd(int canvasHeight) {
		if (position.y <= 0 || position.y >= canvasHeight - height) {
			return true;
		}
		return false;
	}

	/**
	 * getter setter
	 * 
	 * @return
	 */
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point newPos) {
		this.position = newPos;
	}

	public int getBitmapId() {
		return bitmapId;
	}

	public void setBitmapId(int bitmapId) {
		this.bitmapId = bitmapId;
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

}
