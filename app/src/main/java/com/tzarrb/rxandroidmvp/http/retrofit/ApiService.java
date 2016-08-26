package com.tzarrb.rxandroidmvp.http.retrofit;

import com.tzarrb.rxandroidmvp.data.bean.ImageDetailBean;
import com.tzarrb.rxandroidmvp.data.bean.ImageListBean;
import com.tzarrb.rxandroidmvp.data.bean.ImageNewBean;
import com.tzarrb.rxandroidmvp.data.bean.NewsDetailBean;
import com.tzarrb.rxandroidmvp.data.bean.NewsListBean;
import com.tzarrb.rxandroidmvp.data.bean.TabNameBean;
import com.tzarrb.rxandroidmvp.data.bean.TabNewsBean;
import com.tzarrb.rxandroidmvp.http.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ivan on 2016/7/6.
 */
public interface ApiService {

    @GET(Api.TAB_NEWS)
    Observable<TabNewsBean> getNewsTabName();

    @GET(Api.TAB_NAME)
    Observable<TabNameBean> getImageTabName();

    @GET(Api.NEWS_LIST)
    Observable<NewsListBean> getNewsList(@Query("id") int id, @Query("page") int page);


    @GET(Api.NEWS_SHOW)
    Observable<NewsDetailBean> getNewsDetail(@Query("id") int id);


    @GET(Api.IMAGE_LIST)
    Observable<ImageListBean> getImageList(@Query("id") int id, @Query("page") int page);


    @GET(Api.IMAGE_NEW)
    Observable<ImageNewBean> getImageNews(@Query("id") int id, @Query("rows") int rows);


    @GET(Api.IMAGE_SHOW)
    Observable<ImageDetailBean> getImageDetail(@Query("id") int id);

}
