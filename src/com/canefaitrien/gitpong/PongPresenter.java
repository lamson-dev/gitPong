// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * mainscreen presenter
 */
package com.canefaitrien.gitpong;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class PongPresenter {

	private static final String TAG = "PongPresenter";
	private IPongView mView;
	// private IPongModel mPong;
	private IBallModel mBall;
	private IPaddleModel mPaddle;

	private int canvasWidth;
	private int canvasHeight;

	public PongPresenter(IPongView view) {
		mView = view;
		// mPong = new Pong();
		mBall = new Ball();
		mPaddle = new Paddle();
	}

	// need to fix this, i don't like passing in these parameters
	public void moveBall(int canvasWidth, int canvasHeight) {
		if (mBall.hitEdge(canvasWidth)) {
			mBall.setVx(mBall.getVx() * (-1));
		}

		if (mBall.hitPaddle(mPaddle.getX(), mPaddle.getY(), mPaddle.getWidth())) {
			mBall.setVy(mBall.getVy() * (-1));
		}

		if (mBall.hitEnd(canvasHeight)) {
			mBall.setVy(mBall.getVy() * (-1));
		}
		mBall.updateX();
		mBall.updateY();
	}

	public IBallModel getBall() {
		return mBall;
	}

	public IPaddleModel getPaddle() {
		return mPaddle;
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
