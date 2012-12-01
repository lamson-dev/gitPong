/**
 * 
 */
package com.canefaitrien.gitpong;

import android.os.Bundle;

/**
 * @author Son Nguyen
 * 
 */
public class DemoPongActivity extends RootActivity {

	private static final String TAG = "Pong";
	private boolean continueMusic;

	/**
	 * Method onCreate.
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pong);
	}

	/**
	 * 
	 */
	public DemoPongActivity() {
		// TODO Auto-generated constructor stub
	}

}
