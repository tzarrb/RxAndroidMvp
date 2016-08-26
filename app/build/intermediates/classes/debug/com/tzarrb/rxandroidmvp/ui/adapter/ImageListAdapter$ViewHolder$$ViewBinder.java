// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ImageListAdapter$ViewHolder$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.adapter.ImageListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492927, "field 'iv'");
    target.iv = finder.castView(view, 2131492927, "field 'iv'");
    view = finder.findRequiredView(source, 2131492993, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131492993, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131492994, "field 'tvSize'");
    target.tvSize = finder.castView(view, 2131492994, "field 'tvSize'");
    view = finder.findRequiredView(source, 2131492995, "field 'tvCount'");
    target.tvCount = finder.castView(view, 2131492995, "field 'tvCount'");
  }

  @Override public void unbind(T target) {
    target.iv = null;
    target.tvTitle = null;
    target.tvSize = null;
    target.tvCount = null;
  }
}
