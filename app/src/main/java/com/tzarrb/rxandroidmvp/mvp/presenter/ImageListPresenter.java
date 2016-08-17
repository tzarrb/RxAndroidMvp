package com.tzarrb.rxandroidmvp.mvp.presenter;

import android.content.Context;

import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.data.bean.ImageListBean;
import com.tzarrb.rxandroidmvp.data.entity.ImageListInfo;
import com.tzarrb.rxandroidmvp.http.RequestManager;
import com.tzarrb.rxandroidmvp.http.retrofit.MySubscriber;
import com.tzarrb.rxandroidmvp.mvp.view.ImageListView;
import com.tzarrb.rxandroidmvp.ui.activity.ImageDetailActivity;

import java.util.List;

/**
 * Created by ivan on 2016/8/4.
 */
public class ImageListPresenter extends BasePresenter<ImageListView> {

    public ImageListPresenter(Context context) {
        super(context);
    }

    public void requestImageList(int id, int page) {
        if (page == 1) {
            mView.showProgress();
        } else {
            mView.showFoot();
        }
        RequestManager.getInstance(mContext).imageList(id, page, new MySubscriber<ImageListBean>() {
            @Override
            public void onError(Throwable e) {
                mView.hideFoot();
                mView.hideProgress();
                mView.netWorkError();
            }

            @Override
            public void onNext(ImageListBean imageListBean) {
                mView.setImageListInfo(imageListBean.getTngou());
                mView.hideFoot();
                mView.hideProgress();
            }
        });
    }

    public void onClick(ImageListInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

}
