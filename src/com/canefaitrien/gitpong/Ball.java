package com.canefaitrien.gitpong;

import android.graphics.Point;

public class Ball {
	private Point position;
	private int paddleIcon;
	private double speed;
	
	public Ball(){
		paddleIcon = R.drawable.ball_a;
	}
	/**
	 * checks if ball hit a paddle
	 * @return
	 */
	public boolean hitPaddle(){
		return false;
	}
	/**
	 * Checks is the ball is hitting a wall (edge of screen)
	 * @return
	 */
	public boolean hitEdge(){
		return false;
	}
	/**
	 * checks if ball has passed a paddle
	 * @return
	 */
	public boolean hitEnd(){
		return false;
	}
	/**
	 * getter setter
	 * @return
	 */
	public Point getPosition(){
		return position;
	}
}
