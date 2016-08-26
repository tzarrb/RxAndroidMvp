package com.tzarrb.rxandroidmvp.mvp.view;

import com.tzarrb.rxandroidmvp.base.IBaseView;
import com.tzarrb.rxandroidmvp.data.entity.ImageDetailInfo;

import java.util.List;

/**
 * Created by ivan on 2016/8/10.
 */
public interface ImageDetailView extends IBaseView {

    void setImageDetailInfo(List<ImageDetailInfo> imageDetailInfo);

    void netWorkError();

}
