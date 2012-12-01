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

	public PongPresenter(IPongView view) {
		mView = view;
		// mPong = new Pong();
		mBall = new Ball();
		mPaddle = new Paddle();
	}

	public void moveBall(BallView ballView) {
		// if (mPong.getBall().hitEdge(200)) {
		// mPong.getBall().setVx(mPong.getBall().getVx() * (-1));
		// } else if (mPong.getBall().hitEnd(200)) {
		// mPong.getBall().setVy(mPong.getBall().getVy() * (-1));
		// }
		//
		// mPong.getBall().updateX();
		// mPong.getBall().updateY();
		//
		// ballView.setX(mPong.getBall().getX());
		// ballView.setY(mPong.getBall().getY());

		ballView.setX(mBall.getX());
		ballView.setY(mBall.getY());

		if (mBall.hitEdge(200)) {
			mBall.setVx(mBall.getVx() * (-1));
		} else if (mBall.hitEnd(200)) {
			mBall.setVy(mBall.getVy() * (-1));
		}
		mBall.updateX();
		mBall.updateY();

		ballView.invalidate();

	}
}
