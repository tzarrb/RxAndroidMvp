// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ImageDetailActivity$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.activity.ImageDetailActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492970, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131492970, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    target.viewPager = null;
  }
}
