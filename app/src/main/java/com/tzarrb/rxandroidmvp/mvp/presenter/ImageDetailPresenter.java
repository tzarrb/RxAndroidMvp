package com.tzarrb.rxandroidmvp.mvp.presenter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.constant.Constant;
import com.tzarrb.rxandroidmvp.data.bean.ImageDetailBean;
import com.tzarrb.rxandroidmvp.data.bean.ImageListBean;
import com.tzarrb.rxandroidmvp.http.RequestManager;
import com.tzarrb.rxandroidmvp.http.retrofit.MySubscriber;
import com.tzarrb.rxandroidmvp.mvp.view.ImageDetailView;
import com.tzarrb.rxandroidmvp.mvp.view.ImageListView;
import com.tzarrb.rxandroidmvp.utils.T;
import com.tzarrb.rxandroidmvp.utils.UIUtils;

import java.util.List;

import rx.Subscription;

/**
 * Created by ivan on 2016/8/10.
 */
public class ImageDetailPresenter extends BasePresenter<ImageDetailView> {

    public ImageDetailPresenter(Context context) {
        super(context);
    }

    public void requestNetWork(int id) {

        Subscription subscription = RequestManager.getInstance(mContext).imageDetail(id, new MySubscriber<ImageDetailBean>() {
            @Override
            public void onError(Throwable e) {
                mView.netWorkError();
            }

            @Override
            public void onNext(ImageDetailBean imageDetailBean) {
                mView.setImageDetailInfo(imageDetailBean.getList());
            }
        });
        mSubscriptions.add(subscription);
    }

    public void competence(int requestCode, int[] grantResults) {
        if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            //noinspection StatementWithEmptyBody
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                T.showShort(mContext, UIUtils.getString(R.string.competence_error));
            }
        }
    }
}
