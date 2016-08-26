package com.tzarrb.rxandroidmvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BaseFragment;
import com.tzarrb.rxandroidmvp.constant.Constant;
import com.tzarrb.rxandroidmvp.data.entity.ImageListInfo;
import com.tzarrb.rxandroidmvp.mvp.presenter.ImageListPresenter;
import com.tzarrb.rxandroidmvp.mvp.view.ImageListView;
import com.tzarrb.rxandroidmvp.ui.adapter.BaseRecyclerViewAdapter;
import com.tzarrb.rxandroidmvp.ui.adapter.ImageListAdapter;
import com.tzarrb.rxandroidmvp.ui.widget.MyRecyclerView;
import com.tzarrb.rxandroidmvp.utils.T;
import com.tzarrb.rxandroidmvp.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ivan on 2016/8/4.
 */
public class ImageMainFragment extends BaseFragment<ImageListPresenter> implements SwipeRefreshLayout.OnRefreshListener,
        MyRecyclerView.LoadingData, ImageListView, BaseRecyclerViewAdapter.OnItemClickListener<ImageListInfo> {

    private boolean isLoad;

    private LinkedList<ImageListInfo> list;
    private ImageListAdapter adapter;


    private static int page = 1;

    public static ImageMainFragment newInstance(int index) {
        Bundle bundle = new Bundle();
        ImageMainFragment fragment = new ImageMainFragment();
        bundle.putInt(FRAGMENT_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;

    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    protected ImageListPresenter initPresenter() {
        return new ImageListPresenter(mContext);
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void init() {
        if (!isCreated || !isVisible || isLoad) {
            return;
        }

        list = new LinkedList<>();
        adapter = new ImageListAdapter(mContext, list);
        adapter.setOnItemClickListener(this);

        srfLayout.setOnRefreshListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_GRIDVIEW, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                onRefresh();
            }
        });
        isLoad = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isLoad = false;
    }

    @Override
    public void setImageListInfo(List<ImageListInfo> imageListInfo) {
        if (!imageListInfo.isEmpty()) {
            list.addAll(imageListInfo);
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onRefresh() {
        page = 1;
        adapter.removeAll();
        mPresenter.requestImageList(index + 1, page);
    }

    @Override
    public void onLoadMore() {
        if (!srfLayout.isRefreshing()) {
            ++page;
            mPresenter.requestImageList(index + 1, page);
        }
    }


    @Override
    public void netWorkError() {
        T.showShort(mContext, UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {
        srfLayout.setRefreshing(false);
    }

    @Override
    public void showProgress() {
        srfLayout.setRefreshing(true);
    }

    @Override
    public void showFoot() {
        adapter.isShowFooter(true);
    }

    public void hideFoot() {
        adapter.isShowFooter(false);
    }

    @Override
    public void onItemClick(View view, int position, ImageListInfo info) {
        mPresenter.onClick(info);
    }

    @Override
    public void onItemLongClick(View view, int position, ImageListInfo info) {

    }

}
