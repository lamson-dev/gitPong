package com.canefaitrien.gitpong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

public class DemoView extends View {

	Bitmap bmBall;
	Ball ball;
	Point ballPos;

	public DemoView(Context context) {
		super(context);

		ball = new Ball(R.drawable.ball_a);
		bmBall = BitmapFactory.decodeResource(getResources(),
				ball.getBitmapId());

		ball.setWidth(bmBall.getWidth());
		ball.setHeight(bmBall.getHeight());
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int canvasWidth = canvas.getWidth();
		int canvasHeight = canvas.getHeight();

		ballPos = ball.getPosition();

		canvas.drawBitmap(bmBall, ballPos.x, ballPos.y, null);

		if (ball.hitEdge(canvasWidth)) {
			ball.setVx(ball.getVx() * (-1));
		} else if (ball.hitEnd(canvasHeight)) {
			ball.setVy(ball.getVy() * (-1));
		}

		ballPos.x += ball.getVx();
		ballPos.y += ball.getVy();

		ball.setPosition(ballPos);

		invalidate();

	}
}
