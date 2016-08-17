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

/**
 * Created by ivan on 2016/7/11 .
 */
public abstract class BasePresenter<V extends IBaseView> {
    public V mView;
    protected Context mContext;

    protected List<Subscription> subscriptionList;

    public BasePresenter(Context context) {
        mContext = context;
    }

    public void onAttach(V mView){
        this.mView = mView;
    }

    public void onCreate(){
        this.subscriptionList = new ArrayList<>();
    }

    public  void onDestroy(){
        mView = null;
        if (subscriptionList != null && !subscriptionList.isEmpty()){
            for (Subscription subscription : subscriptionList) {
                if (subscription != null && !subscription.isUnsubscribed()) {
                    subscription.unsubscribe();
                }
            }
        }
        subscriptionList = null;
    }

}
