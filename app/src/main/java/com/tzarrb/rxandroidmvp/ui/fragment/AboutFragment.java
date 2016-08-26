package com.tzarrb.rxandroidmvp.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BaseFragment;
import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/2.
 */
public class AboutFragment extends BaseFragment {

    @Override
    public int setLayoutResource() {
        return R.layout.fragment_about;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    public void init() {

    }


}
