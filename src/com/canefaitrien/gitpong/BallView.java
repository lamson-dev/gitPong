package com.canefaitrien.gitpong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

@SuppressLint("ViewConstructor")
public class BallView extends View {

	private final String TAG = "BallView";

	private Bitmap bmBall;
	private float x;
	private float y;
	private PongPresenter mPresenter;
	private IBallModel ball;
	private final Paint paint = new Paint();// normal paint

	public BallView(Context context, PongPresenter presenter) {
		super(context);
		bmBall = BitmapFactory
				.decodeResource(getResources(), R.drawable.ball_a);

		mPresenter = presenter;
		mPresenter.getBall().setWidth(bmBall.getWidth());
		mPresenter.getBall().setHeight(bmBall.getHeight());
		ball = presenter.getBall();
		Log.d(TAG, "Made a ball");
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		ball.getRect().set((int) (ball.getX() - ball.getWidth() / 2),
				(int) (ball.getY() - ball.getHeight() / 2),
				(int) (ball.getX() + ball.getWidth() / 2),
				(int) (ball.getY() + ball.getHeight() / 2));
		canvas.drawBitmap(bmBall, null, ball.getRect(), paint);
		mPresenter.moveBall(canvas.getWidth(), canvas.getHeight());
		// mPresenter.moveBall();
		x = mPresenter.getBall().getX();
		y = mPresenter.getBall().getY();

		// simple AI for paddle2 to follow ball
		mPresenter.getPaddle2().setX(x);

		// Log.d(TAG, "x=" + x + " y=" + y);
		invalidate();
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
