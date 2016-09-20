package shun.com.animation.home.presenter;

import shun.com.animation.home.view.IMainActivity;

/**
 * Created by HX on 2016/9/20.
 */
public class MainPresenter implements IMainPresenter {
    IMainActivity activity;

    public MainPresenter(IMainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void changeAnimation(int flag) {
        activity.changeAnimation(activity.getAnimationStatue(flag), flag);
    }
}
