package com.canefaitrien.gitpong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

public class BallView extends View {

	private Bitmap bmBall;
	private float x;

	private float y;

	public BallView(Context context) {
		super(context);
		bmBall = BitmapFactory
				.decodeResource(getResources(), R.drawable.ball_a);
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(bmBall, x, y, null);
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
