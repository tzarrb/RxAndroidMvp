// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ImageViewPagerFragment$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.fragment.ImageViewPagerFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492992, "field 'tabLayout'");
    target.tabLayout = finder.castView(view, 2131492992, "field 'tabLayout'");
    view = finder.findRequiredView(source, 2131492970, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131492970, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    target.tabLayout = null;
    target.viewPager = null;
  }
}
