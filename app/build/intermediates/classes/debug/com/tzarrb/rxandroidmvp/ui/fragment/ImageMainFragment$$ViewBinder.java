// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ImageMainFragment$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.fragment.ImageMainFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492976, "field 'srfLayout'");
    target.srfLayout = finder.castView(view, 2131492976, "field 'srfLayout'");
    view = finder.findRequiredView(source, 2131492987, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131492987, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    target.srfLayout = null;
    target.recyclerView = null;
  }
}
