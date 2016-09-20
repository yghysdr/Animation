package shun.com.animation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by HX on 2016/9/20.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initContentView();
        initViews();
        initListener();
    }

    /**
     * 获取View
     * @param res 资源id
     * @param <K> view
     * @return 子view
     */
    @SuppressWarnings("unchecked")
    protected <K extends View> K getView(int res){
        return ((K) findViewById(res));
    }

}
