// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewsListAdapter$ViewHolder$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.adapter.NewsListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492927, "field 'image'");
    target.image = finder.castView(view, 2131492927, "field 'image'");
    view = finder.findRequiredView(source, 2131492996, "field 'tvFromname'");
    target.tvFromname = finder.castView(view, 2131492996, "field 'tvFromname'");
    view = finder.findRequiredView(source, 2131492997, "field 'tvTime'");
    target.tvTime = finder.castView(view, 2131492997, "field 'tvTime'");
    view = finder.findRequiredView(source, 2131492993, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131492993, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131492998, "field 'tvUrl'");
    target.tvUrl = finder.castView(view, 2131492998, "field 'tvUrl'");
  }

  @Override public void unbind(T target) {
    target.image = null;
    target.tvFromname = null;
    target.tvTime = null;
    target.tvTitle = null;
    target.tvUrl = null;
  }
}
