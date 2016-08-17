package com.tzarrb.rxandroidmvp.mvp.presenter;

import android.content.Context;

import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.data.bean.TabNameBean;
import com.tzarrb.rxandroidmvp.data.bean.TabNewsBean;
import com.tzarrb.rxandroidmvp.http.RequestManager;
import com.tzarrb.rxandroidmvp.http.retrofit.MySubscriber;
import com.tzarrb.rxandroidmvp.mvp.view.TabNameView;
import com.tzarrb.rxandroidmvp.mvp.view.TabNewsView;

/**
 * Created by ivan on 2016/8/4.
 * Contact with tzarrb@gmail.com.
 */
public class NewsPagerPresenter extends BasePresenter<TabNewsView> {
    public NewsPagerPresenter(Context context) {
        super(context);
    }

    public void requestTabName() {
        RequestManager.getInstance(mContext).newsTabName(new MySubscriber<TabNewsBean>() {
            @Override
            public void onError(Throwable e) {
                mView.netWorkError();
            }

            @Override
            public void onNext(TabNewsBean tabNameBean) {
                mView.addTabName(tabNameBean.getNewsInfo());
            }
        });
    }
}