package com.tzarrb.rxandroidmvp.base;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.media.browse.MediaBrowser;

import com.tzarrb.rxandroidmvp.http.RequestManager;
import com.tzarrb.rxandroidmvp.http.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ivan on 2016/7/11 .
 */
public abstract class BasePresenter<V extends IBaseView> {
    public V mView;
    protected Context mContext;

    protected CompositeSubscription mSubscriptions;

    public BasePresenter(Context context) {
        mContext = context;
    }

    public void onAttach(V mView){
        this.mView = mView;
    }

    public void onCreate(){
        mSubscriptions = new CompositeSubscription();
    }

    public  void onDestroy(){
        mSubscriptions.clear();
        mView = null;
    }

}
