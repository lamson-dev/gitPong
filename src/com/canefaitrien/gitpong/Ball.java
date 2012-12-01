package com.canefaitrien.gitpong;

public class Ball implements IBallModel {
	private float x;
	private float y;
	private float vx;
	private float vy;
	private int width;
	private int height;

	public Ball() {
		setVx(5);
		setVy(5);
		setX(50);
		setY(50);
	}

	public boolean hitPaddle(float padX, float padY) {
		return false;
	}

	public boolean hitEdge(int canvasWidth) {
		if (x <= 0 || x >= canvasWidth - width) {
			return true;
		}
		return false;
	}

	public boolean hitEnd(int canvasHeight) {
		if (y <= 0 || y >= canvasHeight - height) {
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
