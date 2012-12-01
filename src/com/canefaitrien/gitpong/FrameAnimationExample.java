/**
 * 
 */
package com.canefaitrien.gitpong;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FrameAnimationExample extends Activity {
	AnimationDrawable animation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnStart = (Button) findViewById(R.id.btnStart);
		final ImageView imgView = (ImageView) findViewById(R.id.img);

		btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startAnimation();
			}
		});
		imgView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}

	class Starter implements Runnable {
		public void run() {
			animation.start();
		}
	}

	private void startAnimation() {
		animation = new AnimationDrawable();
		animation.addFrame(getResources().getDrawable(R.drawable.pound_anim1),
				100);
		animation.addFrame(getResources().getDrawable(R.drawable.pound_anim2),
				100);
		animation.addFrame(getResources().getDrawable(R.drawable.pound_anim3),
				100);
		animation.addFrame(getResources().getDrawable(R.drawable.pound_anim4),
				100);
		animation.addFrame(getResources().getDrawable(R.drawable.pound_anim5),
				100);
		animation.addFrame(getResources().getDrawable(R.drawable.pound_anim1),
				100);
		animation.setOneShot(true);

		ImageView imageView = (ImageView) findViewById(R.id.img);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		params.alignWithParent = true;
		params.addRule(RelativeLayout.CENTER_IN_PARENT);

		imageView.setLayoutParams(params);
		imageView.setImageDrawable(animation);
		imageView.post(new Starter());
	}
}