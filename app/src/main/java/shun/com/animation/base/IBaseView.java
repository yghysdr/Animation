package shun.com.animation.base;

/**
 * Created by HX on 2016/9/20.
 * 方便统一管理BaseActivity与BaseFragment
 */
public interface IBaseView {
    void init();
    void initContentView();
    void initViews();
    void initListener();
}
