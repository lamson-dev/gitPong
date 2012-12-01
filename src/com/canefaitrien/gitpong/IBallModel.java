/**
 * 
 */
package com.canefaitrien.gitpong;

/**
 * @author Son Nguyen
 * 
 */
public interface IBallModel {

	public boolean hitPaddle(float padX, float padY, float length);

	public boolean hitEdge(int canvasWidth);

	public boolean hitEnd(int canvasHeight);

	public void updateX();

	public void updateY();

	public float getVx();

	public void setVx(float vx);

	public float getVy();

	public void setVy(float vy);

	public int getWidth();

	public void setWidth(int width);

	public int getHeight();

	public void setHeight(int height);

	public float getX();

	public void setX(float x);

	public float getY();

	public void setY(float y);

}
