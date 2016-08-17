package com.tzarrb.rxandroidmvp.http;

import android.content.Context;

import com.tzarrb.rxandroidmvp.data.bean.ImageDetailBean;
import com.tzarrb.rxandroidmvp.data.bean.ImageListBean;
import com.tzarrb.rxandroidmvp.data.bean.ImageNewBean;
import com.tzarrb.rxandroidmvp.data.bean.NewsDetailBean;
import com.tzarrb.rxandroidmvp.data.bean.NewsListBean;
import com.tzarrb.rxandroidmvp.data.bean.TabNameBean;
import com.tzarrb.rxandroidmvp.data.bean.TabNewsBean;
import com.tzarrb.rxandroidmvp.http.retrofit.ApiService;
import com.tzarrb.rxandroidmvp.utils.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ivan on 2016/7/11.
 */
public class RequestManager {
    private static RequestManager instance;
    private static ApiService apiService;

    public RequestManager(Context context){
        apiService = RetrofitUtils.getInstance(context).create(ApiService.class);
    }

    public static RequestManager getInstance(final Context context){
        if (instance == null){
            synchronized (RequestManager.class){
                if (instance == null){
                    instance = new RequestManager(context);
                }
            }
        }

        return instance;
    }

    public void newsTabName(Subscriber<TabNewsBean> subscriber) {
        apiService.getNewsTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void newsList(int id, int page, Subscriber<NewsListBean> subscriber) {
        apiService.getNewsList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void newsDetail(int id, Subscriber<NewsDetailBean> subscriber) {
        apiService.getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void imageTabName(Subscriber<TabNameBean> subscriber) {
        apiService.getImageTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void imageList(int id, int page, Subscriber<ImageListBean> subscriber) {
        apiService.getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void imageDetail(int id, Subscriber<ImageDetailBean> subscriber) {
        apiService.getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void imageNew(int id, int rows, Subscriber<ImageNewBean> subscriber) {
        apiService.getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
