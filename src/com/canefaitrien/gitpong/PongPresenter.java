// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * mainscreen presenter
 */
package com.canefaitrien.gitpong;

import android.util.Log;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class PongPresenter {

	private static final String TAG = "PongPresenter";
	private IPongView mView;
	// private IPongModel mPong;
	private IBallModel mBall;
	private IPaddleModel mPaddle1;
	private IPaddleModel mPaddle2;

	private int canvasWidth;
	private int canvasHeight;

	public PongPresenter(IPongView view) {
		mView = view;
		// mPong = new Pong();
		mBall = new Ball();
		mPaddle1 = new Paddle();
		mPaddle2 = new Paddle();

		mPaddle2.setX(700);
		mPaddle2.setY(100);
	}

	// need to fix this, i don't like passing in these parameters
	public void moveBall(int canvasWidth, int canvasHeight) {
		if (mBall.hitEdge(canvasWidth)) {
			// ballcheck();
			mBall.setVx(mBall.getVx() * (float) (-1.0));

		}

		if ((mBall.getVy() < 0 && mBall.hitPaddle(mPaddle2))
				|| (mBall.getVy() > 0 && mBall.hitPaddle(mPaddle1))) {
			ballcheck();
			mBall.setVy(mBall.getVy() * (float) (-1.1));
			mBall.setVx(mBall.getVx() * (float) (1.04));
		}

		if (mBall.hitEnd(canvasHeight)) {
			mBall.reset();
		}
		mBall.updateX();
		mBall.updateY();
	}

	// checks if the ball is moving too slow or too fast in one vector
	public void ballcheck() {
		if (Math.abs(mBall.getVx()) < 2) {
			Log.d(TAG, "Ball x too slow");
			mBall.setVx(mBall.getVx() * 2);
		}
		if (Math.abs(mBall.getVy()) < 2.5) {
			Log.d(TAG, "Ball y too slow");
			mBall.setVy(mBall.getVy() * 2);
		}
		if (Math.abs(mBall.getVx()) > 12) {
			Log.d(TAG, "Ball x too fast");
			mBall.setVx(mBall.getVx() < 0 ? -12 : 12);
		}
		if (Math.abs(mBall.getVy()) > 12) {
			Log.d(TAG, "Ball y too fast");
			mBall.setVy(mBall.getVy() < 0 ? -12 : 12);
		}
	}

	public void triggerSkillPound() {

		if (mBall.inPoundRange(mPaddle1)) {
			if (mBall.getVx() < 0)
				mBall.setVx(mBall.getVx() * (float) -2.5);
			else if (mBall.getVx() > 0)
				mBall.setVx(mBall.getVx() * (float) 2.5);
			else
				mBall.setVx(5 * (float) 2.5);
			mBall.setVy(mBall.getVy() * (float) -1.1);
		}

	}

	public void triggerStraightBall() {
		if (mBall.getY() >= 600 && mBall.getVy() > 0) {
			mBall.setVy(mBall.getVy() * (float) -1.5);
			mBall.setVx(0);
		}
	}

	public IBallModel getBall() {
		return mBall;
	}

	public IPaddleModel getPaddle() {
		return mPaddle1;
	}

	public IPaddleModel getPaddle2() {
		return mPaddle2;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}
}
