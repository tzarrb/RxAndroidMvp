// Generated code from Butter Knife. Do not modify!
package com.tzarrb.rxandroidmvp.ui.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class WebViewActivity$$ViewBinder<T extends com.tzarrb.rxandroidmvp.ui.activity.WebViewActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492977, "field 'webView'");
    target.webView = finder.castView(view, 2131492977, "field 'webView'");
    view = finder.findRequiredView(source, 2131493012, "field 'toolBar'");
    target.toolBar = finder.castView(view, 2131493012, "field 'toolBar'");
    view = finder.findRequiredView(source, 2131492976, "field 'srfLayout'");
    target.srfLayout = finder.castView(view, 2131492976, "field 'srfLayout'");
  }

  @Override public void unbind(T target) {
    target.webView = null;
    target.toolBar = null;
    target.srfLayout = null;
  }
}
