package com.canefaitrien.gitpong;


import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class CombatActivity extends Activity {
	private static final String Tag = "combat";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final FrameLayout main = new FrameLayout(this);
		main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		main.setBackgroundResource(R.drawable.background_b);

	}
}
