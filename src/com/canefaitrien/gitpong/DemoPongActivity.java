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
public class DemoPongActivity extends RootActivity implements IPongView {

	private static final String TAG = "Pong";
	private boolean continueMusic;

	private BallView ballView;

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

		ballView = new BallView(this);
		main.addView(ballView);
		setContentView(main);
		
		for (int i=0; i < 10000000; i++) {
			mPresenter.moveBall(ballView);
		}
	}

}
