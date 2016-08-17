package com.tzarrb.rxandroidmvp.mvp.view;

import com.tzarrb.rxandroidmvp.base.IBaseView;
import com.tzarrb.rxandroidmvp.data.entity.ImageListInfo;

import java.util.List;

/**
 * Created by ivan on 2016/8/10.
 */
@SuppressWarnings("ALL")
public interface ImageListView extends IBaseView {

    void setImageListInfo(List<ImageListInfo> imageListInfo);

    void netWorkError();

    void hideProgress();
    
    void showProgress();

    void showFoot();

    void hideFoot();
}
