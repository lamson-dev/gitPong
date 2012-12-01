/**
 * 
 */
package com.canefaitrien.gitpong;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * @author Son Nguyen
 * 
 */
public class DemoPongActivity extends RootActivity implements IPongView,
		OnGestureListener {

	private static final String TAG = "Pong";
	private boolean continueMusic;

	private BallView ballView;
	private PaddleView objectsView;
	private GestureDetector gestures;
	private int paddleMovementMaxY;

	protected PongPresenter mPresenter;

	public DemoPongActivity() {
		mPresenter = new PongPresenter(this);
	}

	/**
	 * Method onCreate.
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final FrameLayout main = new FrameLayout(this);
		main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		main.setBackgroundResource(R.drawable.background_b);

		objectsView = new PaddleView(this, mPresenter);
		gestures = new GestureDetector(this);
		paddleMovementMaxY = (int) (mPresenter.getPaddle().getY() - 100);
		main.addView(objectsView);

		ballView = new BallView(this, mPresenter);
		main.addView(ballView);
		setContentView(main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		return gestures.onTouchEvent(e);
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.d(TAG, "flinging");
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		Log.d(TAG,
				"Found a touch!" + (int) e.getRawX() + " " + (int) e.getRawY());
		if (e.getRawY() > paddleMovementMaxY) {
			mPresenter.getPaddle().setTargetx((int) e.getRawX());
		}
		return true;
	}

	// probably going to do nothing
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// Log.d(TAG, "scroll" + (int) e2.getRawX() + " " + (int) e2.getRawY());
		if (e2.getRawY() > paddleMovementMaxY) {
			mPresenter.getPaddle().setTargetx((int) e2.getRawX());
		} else {
			// if(e1.getRawY()>objectsView.getBa)
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
