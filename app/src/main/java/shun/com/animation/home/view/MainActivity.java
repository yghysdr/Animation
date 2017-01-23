package shun.com.animation.home.view;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shun.com.animation.R;
import shun.com.animation.base.BaseActivity;
import shun.com.animation.home.presenter.AnimationPresenter;
import shun.com.animation.home.presenter.IAnimationPresenter;

public class MainActivity extends BaseActivity implements IAnimation {

    public final int DURATION = 2 * 1000;
    public final int REPEAT_COUNT = 1;

    @BindView(R.id.iv_frame)
    ImageView ivFrame;
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
    @BindView(R.id.btn_to_property)
    Button btnToProperty;

    private IAnimationPresenter mMainPresenter;


    private AnimationDrawable mAnimationDrawable;
    private Animation mAlpha;
    private TranslateAnimation mTranslate;
    private ScaleAnimation mScale;
    private RotateAnimation mRotate;

    @Override
    public void init() {
        mMainPresenter = new AnimationPresenter(this);
        initRotate();
        initAlpha();
        initScale();
        initTranslate();
    }

    private void initTranslate() {
        // 位移的x轴起始坐标的类型(相对于自己还是相对父容器)
        int fromXType = Animation.RELATIVE_TO_SELF;
        // x轴起点
        float fromXValue = 1.0f;
        int toXType = Animation.RELATIVE_TO_SELF;
        // X轴的终点
        float toXValue = 0.0f;
        int fromYType = Animation.RELATIVE_TO_SELF;
        // Y轴的起始坐标
        float fromYValue = -0.0f;
        int toYType = Animation.RELATIVE_TO_SELF;
        // Y轴的终点坐标
        float toYValue = 0.0f;
        mTranslate = new TranslateAnimation(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
        mTranslate.setDuration(DURATION);
    }

    private void initScale() {
        // 0.0f代表0点的位置；0.5f代表图片宽度的一半的位置；1.0f代表图片整个图片宽度的位置；2.0f代表整个图片宽度的2倍；
        // 水平方向比例尺的起始值
        float fromX = 0.0f;
        // 水平方向比例尺的终值
        float toX = 2.0f;
        // 垂直方向比例尺的起始值
        float fromY = 0.0f;
        // 垂直方向比例尺的终值
        float toY = 2.0f;
        // X轴的原点的类型（相对于自己而言还是相对于父容器而言）
        int pivotXType = Animation.RELATIVE_TO_SELF;
        // 开始伸缩时的X轴的原点(例:0.5就是指以图片宽度的二分之一的位置作为X轴的原点)
        float pivotXValue = 0.0f;
        int pivotYType = Animation.RELATIVE_TO_SELF;
        float pivotYValue = 0.0f;
        mScale = new ScaleAnimation(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
        mScale.setFillAfter(true);
        mScale.setDuration(DURATION);
    }

    private void initAlpha() {
        mAlpha = new AlphaAnimation(1.0f, 0.0f);
        mAlpha.setDuration(DURATION); // 动画持续多久
        mAlpha.setFillAfter(true); // 设为true之后,界面会停留在动画播放完时的界面
        mAlpha.setRepeatMode(Animation.REVERSE); // 动画重启或逆转，默认值为重启动画
        mAlpha.setRepeatCount(REPEAT_COUNT); // 设置动画重复的次数（不包含原本要执行的那次）

//        mAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
    }

    private void initRotate() {
        // 旋转的起始角度
        float fromDegrees = 0;
        //旋转的目标角度
        float toDegrees = 360;
        //旋转的X轴中心点类型
        //分为三种类型：Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF,Animation.RELATIVE_TO_PARENT.
        //X轴的原点的类型（相对于自己而言还是相对于父容器而言）
        int pivotXType = Animation.RELATIVE_TO_SELF;
        //旋转的X轴坐标的值，一般被指定为一个百分比数；1.0代表着100%
        //开始伸缩时的X轴的原点(例:0.5就是指以图片宽度的二分之一的位置作为X轴的原点)
        float pivotXValue = 0.5f;
        //Y轴的原点的类型
        int pivotYType = Animation.RELATIVE_TO_SELF;
        //开始伸缩时的Y轴的原点
        float pivotYValue = 0.5f;
        /*
         *这里对pivotXValue和pivotYValue的值详细说明一下
         *在Android中的坐标轴Y轴向下是增张的，X轴向右是增长的；
         *pivotXValue在API中被说明为：旋转的X轴坐标的值，一般被指定为一个百分比数；1.0代表着100%
         *也就是说，当我们指定为0.0f时，代表作是图片的X轴的0点；当指定为0.5f时，代表图片的width/2的位置；当被指定为1.0f时，代表图片的width位置；
         */
        mRotate = new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);
        mRotate.setDuration(DURATION); // 动画持续多久
        mRotate.setRepeatCount(REPEAT_COUNT); // 设置动画重复的次数
//        mRotate.setStartOffset(2 * 1000); // 设置动画启动时间的偏移量，简单来说就是多长时间后启动动画
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void changeAnimation(boolean isOpen, int flag) {
        switch (flag) {
            case R.id.iv_frame:
                if (!isOpen) {
                    ivFrame.setBackgroundResource(R.drawable.frame_voice);
                    mAnimationDrawable = (AnimationDrawable) ivFrame.getBackground();
                    mAnimationDrawable.start();
                } else {
                    ivFrame.setBackgroundResource(R.drawable.chat_left_voice_3);
                    mAnimationDrawable.stop();
                }
                break;
            case R.id.btn_alpha:
                ivTween.startAnimation(mAlpha);
                break;
            case R.id.btn_rotate:
                ivTween.startAnimation(mRotate);
                break;
            case R.id.btn_scale:
                ivTween.startAnimation(mScale);
                break;
            case R.id.btn_translate:
                ivTween.startAnimation(mTranslate);
                ivTween.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean getAnimationStatue(int flag) {
        switch (flag) {
            case R.id.iv_frame: {
                if (mAnimationDrawable == null) {
                    return false;
                }
                return mAnimationDrawable.isRunning();
            }
            case R.id.iv_tween:
                return false;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_alpha, R.id.btn_rotate, R.id.btn_scale, R.id.btn_translate, R.id.iv_tween
            , R.id.btn_to_property})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
            case R.id.btn_rotate:
            case R.id.btn_scale:
            case R.id.btn_translate:
            case R.id.iv_tween:
                mMainPresenter.changeAnimation(view.getId());
                break;
            case R.id.btn_to_property:
                startActivity(new Intent(MainActivity.this, PropertyActivity.class));
                break;
        }

    }

}
