package com.tzarrb.rxandroidmvp.ui.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.data.entity.ImageListInfo;
import com.tzarrb.rxandroidmvp.http.Api;
import com.tzarrb.rxandroidmvp.utils.ImageLoaderUtils;
import com.tzarrb.rxandroidmvp.utils.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * Created by ivan on 2016/8/4.
 */
public class ImageListAdapter extends BaseRecyclerViewAdapter<ImageListInfo> {


    public ImageListAdapter(List<ImageListInfo> datas) {
        super(datas);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, final int position, final ImageListInfo data) {
        if (holder instanceof ViewHolder) {
            final ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tvTitle.setText(data.getTitle());
            viewHolder.tvSize.setText(data.getSize() + UIUtils.getString(R.string.list_adapter_number));
            viewHolder.tvCount.setText(UIUtils.getString(R.string.list_adapter_views) + data.getCount());
            ImageLoaderUtils.display(UIUtils.getContext(), viewHolder.iv, Api.IMAGER_URL + data.getImg());
        }
    }

    @Override
    protected BaseRecyclerViewHolder onCreate(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
            return new ViewHolder(view);

        } else if (viewType == TYPE_FOOTER) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false);
            return new BaseRecyclerViewHolder(view);
        }

        return null;
    }

    class ViewHolder extends BaseRecyclerViewHolder {

        @SuppressWarnings("unused")
        @Bind(R.id.image)
        ImageView iv;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_size)
        TextView tvSize;
        @SuppressWarnings("unused")
        @Bind(R.id.tv_count)
        TextView tvCount;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
