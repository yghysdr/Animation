package shun.com.animation.home.presenter;

import shun.com.animation.home.view.IAnimation;

/**
 * Created by HX on 2016/9/20.
 */
public class AnimationPresenter implements IAnimationPresenter {
    IAnimation activity;

    public AnimationPresenter(IAnimation activity) {
        this.activity = activity;
    }

    @Override
    public void changeAnimation(int flag) {
        activity.changeAnimation(activity.getAnimationStatue(flag), flag);
    }
}
