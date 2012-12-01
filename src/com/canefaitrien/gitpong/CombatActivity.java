package com.canefaitrien.gitpong;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class CombatActivity extends RootActivity implements OnGestureListener {
	private static final String TAG = "combat";
	private CombatObjectsView objectsView;
	private GestureDetector gestures;
	private int paddleMovementMaxY;

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final FrameLayout main = new FrameLayout(this);
		main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		main.setBackgroundResource(R.drawable.background_a);
		//
		objectsView = new CombatObjectsView(this);
		gestures = new GestureDetector(this);
		//
		paddleMovementMaxY = (int) (objectsView.getPad1().getY() - 100);
		//
		setContentView(main);
		main.addView(objectsView);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		return gestures.onTouchEvent(e);
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e2.getRawY() < paddleMovementMaxY) {
			Log.d(TAG, "fling");
		}
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		Log.d(TAG,
				"Found a touch!" + (int) e.getRawX() + " " + (int) e.getRawY());
		if (e.getRawY() > paddleMovementMaxY) {
			objectsView.getPad1().setTargetx((int) e.getRawX());
		}
		return true;
	}

	//probably going to do nothing
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.d(TAG, "scroll" + (int) e2.getRawX() + " " + (int) e2.getRawY());
		if (e2.getRawY() > paddleMovementMaxY) {
			objectsView.getPad1().setTargetx((int) e2.getRawX());
		}else{
			//if(e1.getRawY()>objectsView.getBa)
		}
		return true;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
