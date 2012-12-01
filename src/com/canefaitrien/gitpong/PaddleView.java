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
public class PaddleView extends View {
	private final String TAG = "PaddleView";
	private Bitmap bmPaddle1;
	private final Paint paint = new Paint();// normal paint

	private IPaddleModel paddle;

	public PaddleView(Context context, IPaddleModel pad) {
		super(context);

		paddle = pad;

		Log.d(TAG, "Combat Objects Made");
		bmPaddle1 = BitmapFactory.decodeResource(getResources(),
				paddle.getBitmapId());

	}

	// draw
	@SuppressLint("DrawAllocation")
	// too laxy to not redraw rectangle :(
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		paddle.getRect().set((int) (paddle.getX() - paddle.getWidth() / 2),
				(int) (paddle.getY() - paddle.getHeight() / 2),
				(int) (paddle.getX() + paddle.getWidth() / 2),
				(int) (paddle.getY() + paddle.getHeight() / 2));

		if (paddle.getX() < paddle.getTargetx() - 10) {
			paddle.setX(paddle.getX() + paddle.getSpeed());
		} else if (paddle.getX() > paddle.getTargetx() + 10) {
			paddle.setX(paddle.getX() - paddle.getSpeed());
		}

		canvas.drawBitmap(bmPaddle1, null, paddle.getRect(), paint);
		invalidate();
	}
}
