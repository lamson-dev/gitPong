package com.canefaitrien.gitpong;

import android.graphics.Point;

/**
 * Paddle
 * @author DX
 *
 */
public class Paddle{
	private Point position;
	private int paddleIcon;
	private double width;
	private double speed;
	public Paddle(){
		paddleIcon = R.drawable.paddle;
	}
	/**
	 * Getters and setters
	 * @return
	 */
	public Point getPosition(){
		return position;
	}
	public double getWidth(){
		return width;
	}
	public int getIcon(){
		return paddleIcon;
	}
	public void setWidth(double value){
		width = value;
	}
}
