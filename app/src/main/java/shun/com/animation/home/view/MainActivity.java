package shun.com.animation.home.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import shun.com.animation.R;
import shun.com.animation.base.BaseActivity;
import shun.com.animation.home.presenter.IMainPresenter;
import shun.com.animation.home.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements IMainActivity {

    private ImageView ivFrame;
    private AnimationDrawable animationDrawable;
    private IMainPresenter mainPresenter;

    @Override
    public void init() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initViews() {
        ivFrame = (ImageView) findViewById(R.id.iv_frame);
    }

    @Override
    public void initListener() {
        ivFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.changeAnimation(0);
            }
        });
    }


    @Override
    public void changeAnimation(boolean isOpen, int flag) {
        switch (flag) {
            case 0: {
                if (!isOpen) {
                    ivFrame.setBackgroundResource(R.drawable.frame_voice);
                    animationDrawable = (AnimationDrawable) ivFrame.getBackground();
                    animationDrawable.start();
                } else {
                    ivFrame.setBackgroundResource(R.drawable.chat_left_voice_3);
                    animationDrawable.stop();
                }
            }
        }
    }

    @Override
    public boolean getAnimationStatue(int flag) {
        switch (flag) {
            case 0: {
                if (animationDrawable == null) {
                    return false;
                }
                return animationDrawable.isRunning();
            }
            default:
                return false;
        }
    }
}
