package shun.com.animation.home.view;

import android.view.View;

/**
 * Created by HX on 2016/9/20.
 */
public interface IAnimation extends View.OnClickListener{
    void changeAnimation(boolean isOpen, int flag);
    boolean getAnimationStatue(int flag);
}
