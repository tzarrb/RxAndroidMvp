package com.tzarrb.rxandroidmvp.mvp.presenter;

import android.app.Activity;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.mvp.view.MainView;

/**
 * Created by ivan on 2016/7/6.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(Activity activity) {
        super(activity);
    }

    public void switchId(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mView.switchNews();
                break;
            case R.id.navigation_item_image_classification:
                mView.switchImageClassification();
                break;
            case R.id.navigation_about:
                mView.switchAbout();
                break;
            case R.id.navigation_Test:
                mView.switchTest();
        }
    }
}
