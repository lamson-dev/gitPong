/**
 * 
 */
package com.canefaitrien.gitpong;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * @author Son Nguyen
 * 
 */
public class PongActivity extends RootActivity implements IPongView,
		OnGestureListener, OnClickListener {

	private static final String TAG = "Pong";
	private boolean continueMusic;

	private FrameLayout layout;
	private BallView ballView;
	private PaddleView pad1View;
	private PaddleView pad2View;
	private GestureDetector gestures;
	private Button skill1;
	private Button skill2;
	private int paddleMovementMaxY;
	private IBallModel ball;
	private IPaddleModel pad1, pad2;

	AnimationDrawable animation;
	AnimationDrawable animationButton;
	Drawable[] animFrames;

	private ImageView animPad;
	private ImageView animBtn;

	protected PongPresenter mPresenter;

	public PongActivity() {
		mPresenter = new PongPresenter(this);
		ball = mPresenter.getBall();
		pad1 = mPresenter.getPaddle();
		pad2 = mPresenter.getPaddle2();
		continueMusic = true;
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
		setContentView(R.layout.activity_pong);
		layout = (FrameLayout) findViewById(R.id.frame_pong);

		pad1View = new PaddleView(this, pad1);
		pad2View = new PaddleView(this, pad2);

		gestures = new GestureDetector(this);
		paddleMovementMaxY = (int) (mPresenter.getPaddle().getY() - 100);
		layout.addView(pad1View);
		layout.addView(pad2View);

		ballView = new BallView(this, mPresenter);
		layout.addView(ballView);

		skill1 = (Button) findViewById(R.id.skill_pound);
		skill2 = (Button) findViewById(R.id.skill_stretch);
		skill1.setOnClickListener(this);
		skill2.setOnClickListener(this);

		int frames[] = { R.drawable.pound_anim1_small,
				R.drawable.pound_anim2_small, R.drawable.pound_anim3_small,
				R.drawable.pound_anim4_small, R.drawable.pound_anim5_small,
				R.drawable.pound_anim1_small };

		animPad = (ImageView) findViewById(R.id.img);
		animBtn = (ImageView) findViewById(R.id.img_btn);
		animFrames = resizeAnimationFrames(frames);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.skill_pound:
			pad1View.setVisibility(View.INVISIBLE);
			animPad.setVisibility(View.VISIBLE);
			pad1View.postDelayed(new Runnable() {
				@Override
				public void run() {
					pad1View.setVisibility(View.VISIBLE);
					animPad.setVisibility(View.GONE);
				}
			}, 300);
			startAnimation();
			mPresenter.triggerSkillPound();
			break;
		case R.id.skill_stretch:
			skill2.setVisibility(View.INVISIBLE);
			animBtn.setVisibility(View.VISIBLE);
			skill2.postDelayed(new Runnable() {
				@Override
				public void run() {
					skill2.setVisibility(View.VISIBLE);
					animBtn.setVisibility(View.GONE);
				}
			}, 3000);
			mPresenter.triggerStraightBall();
			blinkButton(skill2, R.drawable.skill_stretch,
					R.drawable.skill_stretch_pressed);
			// Handler myHandler = new Handler();
			// myHandler.postDelayed(mMyRunnable, 1000);
			// animation.stop();
			break;
		}

	}

	private Runnable mMyRunnable = new Runnable() {
		@Override
		public void run() {
			// Change state here
		}
	};

	class Starter implements Runnable {
		public void run() {
			animation.start();
		}
	}

	class StarterButton implements Runnable {
		public void run() {
			animationButton.start();
		}
	}

	private Drawable[] resizeAnimationFrames(int[] frames) {
		Drawable[] drawableFrames = new Drawable[frames.length];
		for (int i = 0; i < frames.length; i++) {

			Drawable frame = getResources().getDrawable(frames[i]);
			Bitmap bitmap = ((BitmapDrawable) frame).getBitmap();
			drawableFrames[i] = new BitmapDrawable(getResources(),
					Bitmap.createScaledBitmap(bitmap, pad1.getWidth(),
							pad1.getWidth(), true));
		}
		return drawableFrames;
	}

	private void blinkButton(Button skill, int id1, int id2) {
		int duration = 100;

		animationButton = new AnimationDrawable();
		animationButton.addFrame(getResources().getDrawable(id1), duration);
		animationButton.addFrame(getResources().getDrawable(id2), duration);
		animationButton.setOneShot(false);

		animBtn.setX(skill.getX());
		animBtn.setY(skill.getY());
		animBtn.setImageDrawable(animationButton);
		animBtn.post(new StarterButton());
	}

	private void startAnimation() {
		int duration = 70;

		animation = new AnimationDrawable();
		for (Drawable frame : animFrames)
			animation.addFrame(frame, duration);
		animation.setOneShot(true);

		animPad.setX(pad1.getX() - pad1.getWidth() / 2);
		animPad.setY(pad1.getY() - pad1.getWidth() + pad1.getHeight() / 2);
		// RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
		// LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		// params.alignWithParent = true;
		// params.addRule(RelativeLayout.CENTER_IN_PARENT);
		// imageView.setLayoutParams(params);
		animPad.setImageDrawable(animation);
		animPad.post(new Starter());
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		return gestures.onTouchEvent(e);
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {

		if (velocityX < 50)
			return false;

		pad1View.setVisibility(View.INVISIBLE);
		animPad.setVisibility(View.VISIBLE);
		pad1View.postDelayed(new Runnable() {
			@Override
			public void run() {
				pad1View.setVisibility(View.VISIBLE);
				animPad.setVisibility(View.GONE);
			}
		}, 300);
		startAnimation();
		mPresenter.triggerSkillPound();

		skill1.setVisibility(View.INVISIBLE);
		animBtn.setVisibility(View.VISIBLE);
		skill1.postDelayed(new Runnable() {
			@Override
			public void run() {
				skill1.setVisibility(View.VISIBLE);
				animBtn.setVisibility(View.GONE);
			}
		}, 2000);
		blinkButton(skill1, R.drawable.skill_pound,
				R.drawable.skill_pound_pressed);
		// if (e2.getRawY() < 1000) {
		// Log.d(TAG, "flinging");
		// ball.setVx(ball.getVx() * (float) 1.6);
		// ball.setVy(ball.getVy() * (float) .7);
		// }
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

	/**
	 * make sure music keeps playing without disruption when user press Back
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		continueMusic = true;
	}

	/**
	 * pause music when activity is paused
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	/**
	 * resume/start music without disruption
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_MENU);

	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**
	 * other fundamental android methods
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	/**
	 * Method onStop.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
		finish();
	}

	/**
	 * Method onRestart.
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

}
