package com.canefaitrien.gitpong;

public class Pong implements IPongModel {

	private Ball ball;
	private Paddle paddle;

	public Pong() {
		ball = new Ball();
		paddle = new Paddle();
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}
}
