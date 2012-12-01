package com.canefaitrien.gitpong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

public class PaddleView extends View {
	private final String TAG = "Combat";
	private Bitmap bmPaddle1;
	private Rect pad1rect;
	private Rect pad2rect;
	private final Paint paint = new Paint();// normal paint

	private PongPresenter mPresenter;

	private IPaddleModel pad1;
	private IPaddleModel pad2;

	public PaddleView(Context context, PongPresenter presenter) {
		super(context);

		mPresenter = presenter;
		pad1 = mPresenter.getPaddle();
		pad2 = mPresenter.getPaddle2();

		Log.d(TAG, "Combat Objects Made");
		bmPaddle1 = BitmapFactory.decodeResource(getResources(), mPresenter
				.getPaddle().getBitmapId());

	}

	// draw
	@SuppressLint("DrawAllocation")
	// too laxy to not redraw rectangle :(
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// draw paddle's new positions
		pad1rect = new Rect((int) (pad1.getX() - pad1.getWidth() / 2),
				(int) (pad1.getY() - pad1.getHeight()),
				(int) (pad1.getX() + pad1.getWidth() / 2),
				(int) (pad1.getY() + pad1.getHeight()));

		pad2rect = new Rect((int) (pad2.getX() - pad2.getWidth() / 2),
				(int) (pad2.getY() - pad2.getHeight()),
				(int) (pad2.getX() + pad2.getWidth() / 2),
				(int) (pad2.getY() + pad2.getHeight()));

		float pad1x = pad1.getX();
		float pad1targetx = pad1.getTargetx();

		if (pad1x < pad1targetx - 10) {
			pad1.setX(pad1x + pad1.getSpeed());
		} else if (pad1x > pad1targetx + 10) {
			pad1.setX(pad1x - pad1.getSpeed());
		}

		float pad2x = pad2.getX();
		float pad2targetx = mPresenter.getBall().getX();

		if (pad2x < pad2targetx - 10) {
			pad2.setX(pad2x + pad2.getSpeed());
		} else if (pad2x > pad2targetx + 10) {
			pad2.setX(pad2x - pad2.getSpeed());
		}

		canvas.drawBitmap(bmPaddle1, null, pad1rect, paint);
		canvas.drawBitmap(bmPaddle1, null, pad2rect, paint);
		// do it again
		invalidate();
	}

}
