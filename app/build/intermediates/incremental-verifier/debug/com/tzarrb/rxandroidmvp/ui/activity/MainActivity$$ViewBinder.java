// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.activity.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493012, "field 'toolBar'");
    target.toolBar = finder.castView(view, 2131493012, "field 'toolBar'");
    view = finder.findRequiredView(source, 2131492974, "field 'navigationView'");
    target.navigationView = finder.castView(view, 2131492974, "field 'navigationView'");
    view = finder.findRequiredView(source, 2131492971, "field 'drawerLayout'");
    target.drawerLayout = finder.castView(view, 2131492971, "field 'drawerLayout'");
  }

  @Override public void unbind(T target) {
    target.toolBar = null;
    target.navigationView = null;
    target.drawerLayout = null;
  }
}
