/**
 * 
 */
package com.canefaitrien.gitpong;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.widget.FrameLayout;

/**
 * @author Son Nguyen
 * 
 */
public class DemoPongActivity extends RootActivity {

	private static final String TAG = "Pong";
	private boolean continueMusic;

	private DemoView ball;

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
		super.onCreate(savedInstanceState);
		ball = new DemoView(this);
		// ball.setOnTouchListener(this);
		setContentView(main);
		main.setBackgroundResource(R.drawable.background_b);
		main.addView(ball);

		setContentView(main);
	}

	/**
	 * 
	 */
	public DemoPongActivity() {
		// TODO Auto-generated constructor stub
	}

}
