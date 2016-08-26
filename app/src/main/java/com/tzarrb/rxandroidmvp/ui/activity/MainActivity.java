package com.tzarrb.rxandroidmvp.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BaseActivity;
import com.tzarrb.rxandroidmvp.mvp.presenter.MainPresenter;
import com.tzarrb.rxandroidmvp.mvp.view.MainView;
import com.tzarrb.rxandroidmvp.ui.fragment.AboutFragment;
import com.tzarrb.rxandroidmvp.ui.fragment.ImageViewPagerFragment;
import com.tzarrb.rxandroidmvp.ui.fragment.NewsViewPagerFragment;
import com.tzarrb.rxandroidmvp.ui.fragment.TestFragment;
import com.tzarrb.rxandroidmvp.utils.UIUtils;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Bind(R.id.toolBar)
    Toolbar toolBar;

    @Bind(R.id.navigation_view)
    NavigationView navigationView;

    @Bind(R.id.dl_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected int setLayoutResource(){
        return R.layout.activity_main;
    }

    protected MainPresenter initPresenter(){
        return new MainPresenter(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
    }

    protected void init(){
        toolBar.setTitle(UIUtils.getString(R.string.news));
        setSupportActionBar(toolBar);
        setupDrawerContent(navigationView);
        switchNews();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mPresenter.switchId(menuItem.getItemId());
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void switchNews() {
        toolBar.setTitle(UIUtils.getString(R.string.news));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new NewsViewPagerFragment()).commit();
    }

    @Override
    public void switchImageClassification() {
        toolBar.setTitle(UIUtils.getString(R.string.toolbar_image_viewpager));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ImageViewPagerFragment()).commit();
    }

    @Override
    public void switchAbout() {
        toolBar.setTitle(UIUtils.getString(R.string.toolbar_about));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new AboutFragment()).commit();
    }

    @Override
    public void switchTest() {
        toolBar.setTitle(UIUtils.getString(R.string.toolbar_test));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new TestFragment()).commit();
    }

}
