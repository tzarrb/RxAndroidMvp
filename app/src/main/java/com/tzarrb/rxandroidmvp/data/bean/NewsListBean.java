package com.tzarrb.rxandroidmvp.data.bean;

import com.tzarrb.rxandroidmvp.data.entity.NewsListInfo;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
@SuppressWarnings("ALL")
public class NewsListBean {

    private List<NewsListInfo> tngou;

    public List<NewsListInfo> getTngou() {
        return tngou;
    }

    public void setTngou(List<NewsListInfo> tngou) {
        this.tngou = tngou;
    }

}
