package com.tzarrb.rxandroidmvp.mvp.view;

import com.tzarrb.rxandroidmvp.base.IBaseView;
import com.tzarrb.rxandroidmvp.data.entity.TabNameInfo;

import java.util.List;

/**
 * Created by ivan on 2016/8/4 .
 */
public interface TabNewsView extends IBaseView {

    void addTabName(List<TabNameInfo> tabNameInfo);

    void netWorkError();

}
