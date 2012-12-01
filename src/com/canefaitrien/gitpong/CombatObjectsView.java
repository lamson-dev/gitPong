package com.canefaitrien.gitpong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class CombatObjectsView extends View {
	private final String TAG = "Combat";
	private Paddle pad1, pad2;
	private Bitmap pad1icon, pad2icon;
	private final Paint paint = new Paint();// normal paint

	public CombatObjectsView(Context context) {
		super(context);
		pad1 = new Paddle();
		pad1icon = BitmapFactory.decodeResource(getResources(),
				pad1.getBitmapId());
	}

	// draw
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(pad1icon, pad1.getPosition().x
				- (pad1icon.getWidth() / 2),
				pad1.getPosition().y - (pad1icon.getHeight() / 2), paint);
		if (pad1.getPosition().x < pad1.getTargx()-10) {
			pad1.setX((int) (pad1.getPosition().x + pad1.getSpeed()));
		} else if (pad1.getPosition().x > pad1.getTargx()+10) {
			pad1.setX((int) (pad1.getPosition().x - pad1.getSpeed()));
		}
		invalidate();
	}

	public void movePad1X(double newx) {
		Log.d(TAG, "moving");

	}

	// getter setter
	public Paddle getPad1() {
		return pad1;
	}
}
