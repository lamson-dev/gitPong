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

public class CombatObjectsView extends View {
	private final String TAG = "Combat";
	private Paddle pad1;
	private Bitmap pad1bitmap;
	private Rect pad1rect;
	private final Paint paint = new Paint();// normal paint

	public CombatObjectsView(Context context) {
		super(context);
		Log.d(TAG, "Combat Objects Made");
		pad1 = new Paddle();
		pad1bitmap = BitmapFactory.decodeResource(getResources(),
				pad1.getBitmapId());

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

		float pad1x = pad1.getX();
		float pad1targetx = pad1.getTargetx();
		if (pad1x < pad1targetx - 10) {
			pad1.setX((float) (pad1x + pad1.getSpeed()));
		} else if (pad1x > pad1targetx + 10) {
			pad1.setX((float) (pad1x - pad1.getSpeed()));
		}
		canvas.drawBitmap(pad1bitmap, null, pad1rect, paint);
		// do it again
		invalidate();
	}

	// getter setter
	public Paddle getPad1() {
		return pad1;
	}
}
