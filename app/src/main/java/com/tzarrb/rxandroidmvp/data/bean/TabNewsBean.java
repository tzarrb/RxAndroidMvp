package com.tzarrb.rxandroidmvp.data.bean;

import com.tzarrb.rxandroidmvp.data.entity.TabNameInfo;

import java.util.List;

/**
 * Created by ivan on 2016/8/5.
 */
public class TabNewsBean {

    private List<TabNameInfo> tngou;

    public List<TabNameInfo> getNewsInfo() {
        return tngou;
    }

    public void setNewsInfo(List<TabNameInfo> tngou) {
        this.tngou = tngou;
    }

}
