package com.tzarrb.rxandroidmvp.mvp.presenter;

import android.content.Context;

import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.data.bean.TabNameBean;
import com.tzarrb.rxandroidmvp.http.RequestManager;
import com.tzarrb.rxandroidmvp.http.retrofit.MySubscriber;
import com.tzarrb.rxandroidmvp.mvp.view.TabNameView;

import rx.Subscription;

/**
 * Created by ivan on 2016/8/4.
 * Contact with tzarrb@gmail.com.
 */
public class ImagePagerPresenter extends BasePresenter<TabNameView> {
    public ImagePagerPresenter(Context context) {
        super(context);
    }

    public void requestTabName() {
        Subscription subscription = RequestManager.getInstance(mContext).imageTabName(new MySubscriber<TabNameBean>() {
            @Override
            public void onError(Throwable e) {
                mView.netWorkError();
            }

            @Override
            public void onNext(TabNameBean tabNameBean) {
                mView.addTabName(tabNameBean.getTngou());
            }
        });
        mSubscriptions.add(subscription);
    }
}