package com.canefaitrien.gitpong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.View;

public class BallView extends View {

	private final String TAG = "BallView";

	private Bitmap bmBall;
	private float x;
	private float y;
	private PongPresenter mPresenter;

	public BallView(Context context, PongPresenter presenter) {
		super(context);
		bmBall = BitmapFactory
				.decodeResource(getResources(), R.drawable.ball_a);

		mPresenter = presenter;
		mPresenter.getBall().setWidth(bmBall.getWidth());
		mPresenter.getBall().setHeight(bmBall.getHeight());
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(bmBall, x, y, null);
		mPresenter.moveBall(canvas.getWidth(), canvas.getHeight());
		// mPresenter.moveBall();
		x = mPresenter.getBall().getX();
		y = mPresenter.getBall().getY();

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
