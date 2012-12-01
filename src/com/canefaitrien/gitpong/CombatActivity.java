package com.canefaitrien.gitpong;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class CombatActivity extends RootActivity implements OnTouchListener{
	private static final String TAG = "combat";
	private CombatObjectsView objectsView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final FrameLayout main = new FrameLayout(this);
		main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		main.setBackgroundResource(R.drawable.background_a);

		objectsView = new CombatObjectsView(this);
		objectsView.setOnTouchListener(this);

		setContentView(main);

		main.addView(objectsView);
	}

	//touch dat
	public boolean onTouch(View v, MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_MOVE || e.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d(TAG, "Found a touch!" + (int) e.getRawX() + " " + (int) e.getRawY());
			objectsView.getPad1().setTargx((int)e.getRawX());

		}
		return true;
	}
}
