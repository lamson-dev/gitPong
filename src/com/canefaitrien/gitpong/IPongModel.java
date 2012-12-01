/**
 * 
 */
package com.canefaitrien.gitpong;

/**
 * @author Son Nguyen
 * 
 */
public interface IPongModel {

	public Ball getBall();

	public void setBall(Ball ball);

	public Paddle getPaddle();

	public void setPaddle(Paddle paddle);

}
