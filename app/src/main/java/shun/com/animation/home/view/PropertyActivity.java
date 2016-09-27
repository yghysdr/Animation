package shun.com.animation.home.view;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import shun.com.animation.R;
import shun.com.animation.base.BaseActivity;
import shun.com.animation.home.presenter.AnimationPresenter;
import shun.com.animation.home.presenter.IAnimationPresenter;

public class PropertyActivity extends BaseActivity implements IAnimation {
    public IAnimationPresenter mAnimationPresenter;

    public final int DURATION = 2 * 1000;
    public final int REPEAT_COUNT = 1;


    @BindView(R.id.btn_alpha)
    Button btnAlpha;
    @BindView(R.id.btn_rotate)
    Button btnRotate;
    @BindView(R.id.btn_scale)
    Button btnScale;
    @BindView(R.id.btn_translate)
    Button btnTranslate;
    @BindView(R.id.iv_tween)
    ImageView ivTween;

    @Override
    public void init() {
        mAnimationPresenter = new AnimationPresenter(this);
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_property);
    }


    @Override
    public void changeAnimation(boolean isOpen, int flag) {
        //alpha、rotation、translationX和scaleY
        //淡入淡出、旋转、水平移动、垂直缩放这几种动画
//        float curTranslationX = ivTween.getTranslationX();
//
//

        switch (flag) {
            case R.id.btn_alpha:
                ObjectAnimator
                        .ofFloat(ivTween, "alpha", 0f, 1f, 0.5f)
                        .setDuration(DURATION)
                        .start();
                break;
            case R.id.btn_rotate:
                if (isOpen) {
                    ObjectAnimator
                            .ofFloat(ivTween, "rotationX", 0.0f, 180.0f)//ofInt区别是动画过度的精确度。
                            .setDuration(DURATION)
                            .start();
                } else {
                    ObjectAnimator
                            .ofFloat(ivTween, "rotationX", 180.0f, 360.0f)
                            .setDuration(DURATION)
                            .start();
                }
                break;
            case R.id.btn_scale:
                ObjectAnimator
                        .ofFloat(ivTween, "scaleX", 1f, 2f, 4f, 1f)//ofInt区别是动画过度的精确度。
                        .setDuration(DURATION)
                        .start();
                break;
            case R.id.btn_translate:
                ObjectAnimator
                        .ofFloat(ivTween, "translationX", 0, 100, 40)
                        .setDuration(DURATION)
                        .start();
                break;
        }
    }

    boolean mIsOpen = true;

    @Override
    public boolean getAnimationStatue(int flag) {
        mIsOpen = !mIsOpen;
        return mIsOpen;
    }


    @OnClick({R.id.btn_alpha, R.id.btn_rotate, R.id.btn_scale, R.id.btn_translate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                break;
            case R.id.btn_rotate:
                break;
            case R.id.btn_scale:
                break;
            case R.id.btn_translate:
                break;
        }
        mAnimationPresenter.changeAnimation(view.getId());
    }
}
