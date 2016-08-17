package com.tzarrb.rxandroidmvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tzarrb.rxandroidmvp.data.entity.TabNameInfo;
import com.tzarrb.rxandroidmvp.ui.fragment.ImageMainFragment;

import java.util.List;

/**
 * Created by ivan on 2016/8/10.
 * Contact with tzarrb@gmail.com.
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {

    private final List<TabNameInfo> mData;

    public ImagePagerAdapter(FragmentManager fm, List<TabNameInfo> mDatas) {
        super(fm);
        this.mData = mDatas;
    }

    @Override
    public Fragment getItem(int position) {
        return ImageMainFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position).getName();
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
