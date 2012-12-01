package com.canefaitrien.gitpong;


/**
 * Paddle
 * @author DX
 *
 */
public class Paddle{
	private float x, y, targetx;
	private int bitmapId;
	private int width,height; //width
	private float vx; //x velocity
	public Paddle(){
		bitmapId = R.drawable.paddle;
		vx = 10;
		width = 210;
		height = 30;
		//test position
		x = 700;
		y = 1050;
		targetx = x;
	}
	/**
	 * Getters and setters
	 * @return
	 */
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setX(float newx){
		x = newx;
	}
	public void setY(float newy){
		y = newy;
	}
	public float getTargetx(){
		return targetx;
	}
	public void setTargetx(float newx){
		targetx = newx;
	}
	//target y goes here
	public void setPosition(int newx, int newy){
		x = newx;
		y = newy;
	}
	public int getWidth(){
		return width;
	}
	public void setWidth(int value){
		width = value;
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int value){
		height = value;
	}
	public float getSpeed(){
		return vx;
	}
	public int getBitmapId(){
		return bitmapId;
	}
	
}
