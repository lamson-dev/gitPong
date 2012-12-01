package com.canefaitrien.gitpong;

public interface IPaddleModel {
	public float getX();

	public float getY();

	public void setX(float newx);

	public void setY(float newy);

	public float getTargetx();

	public void setTargetx(float newx);

	public void setPosition(int newx, int newy);

	public int getWidth();

	public void setWidth(int value);

	public int getHeight();

	public void setHeight(int value);

	public float getSpeed();

	public int getBitmapId();
}
