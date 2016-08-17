// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TestFragment$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.fragment.TestFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492988, "field 'et1'");
    target.et1 = finder.castView(view, 2131492988, "field 'et1'");
    view = finder.findRequiredView(source, 2131492989, "field 'et2'");
    target.et2 = finder.castView(view, 2131492989, "field 'et2'");
    view = finder.findRequiredView(source, 2131492990, "field 'et3'");
    target.et3 = finder.castView(view, 2131492990, "field 'et3'");
    view = finder.findRequiredView(source, 2131492991, "field 'btn'");
    target.btn = finder.castView(view, 2131492991, "field 'btn'");
  }

  @Override public void unbind(T target) {
    target.et1 = null;
    target.et2 = null;
    target.et3 = null;
    target.btn = null;
  }
}
