package com.tzarrb.rxandroidmvp.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BaseFragment;
import com.tzarrb.rxandroidmvp.data.entity.TabNameInfo;
import com.tzarrb.rxandroidmvp.mvp.presenter.ImagePagerPresenter;
import com.tzarrb.rxandroidmvp.mvp.view.TabNameView;
import com.tzarrb.rxandroidmvp.ui.adapter.ImagePagerAdapter;
import com.tzarrb.rxandroidmvp.utils.T;
import com.tzarrb.rxandroidmvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ivan on 2016/8/4.
 */
public class ImageViewPagerFragment extends BaseFragment<ImagePagerPresenter> implements TabNameView {

    @SuppressWarnings("unused")
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private ImagePagerAdapter tabNameAdapter;
    private List<TabNameInfo> data;

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_viewpager;
    }

    @Override
    protected ImagePagerPresenter initPresenter() {
        return new ImagePagerPresenter(mContext);
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void init() {
        mPresenter.requestTabName();
        data = new LinkedList<>();
        tabNameAdapter = new ImagePagerAdapter(getChildFragmentManager(), data);

    }

    @Override
    public void addTabName(List<TabNameInfo> tabNameInfo) {
        if (!tabNameInfo.isEmpty()) {
            data.addAll(tabNameInfo);
            viewPager.setAdapter(tabNameAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        T.showShort(mContext, UIUtils.getContext().getResources().getString(R.string.network_error));
    }
}
