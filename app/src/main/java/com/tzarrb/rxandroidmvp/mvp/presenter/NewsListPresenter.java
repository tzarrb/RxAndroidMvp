package com.tzarrb.rxandroidmvp.mvp.presenter;

import android.content.Context;

import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.data.bean.NewsListBean;
import com.tzarrb.rxandroidmvp.data.entity.NewsListInfo;
import com.tzarrb.rxandroidmvp.http.RequestManager;
import com.tzarrb.rxandroidmvp.http.retrofit.MySubscriber;
import com.tzarrb.rxandroidmvp.mvp.view.NewsListView;

/**
 * Created by ivan on 2016/8/4.
 */
public class NewsListPresenter extends BasePresenter<NewsListView> {
    public NewsListPresenter(Context context) {
        super(context);
    }

    public void requestNewsList(int id, int page) {
        if (page == 1) {
            mView.showProgress();
        } else {
            mView.showFoot();
        }
        RequestManager.getInstance(mContext).newsList(id, page, new MySubscriber<NewsListBean>() {
            @Override
            public void onError(Throwable e) {
                mView.hideFoot();
                mView.hideProgress();
                mView.netWorkError();
            }

            @Override
            public void onNext(NewsListBean newsListBean) {
                mView.setNewsListInfo(newsListBean.getTngou());
                mView.hideFoot();
                mView.hideProgress();
            }
        });
    }

    public void onClick(NewsListInfo info) {

    }
}
