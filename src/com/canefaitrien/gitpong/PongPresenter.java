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

	@SuppressWarnings("unused")
	private final IPongView mView;

	public PongPresenter(IPongView view) {
		mView = view;
	}

}
