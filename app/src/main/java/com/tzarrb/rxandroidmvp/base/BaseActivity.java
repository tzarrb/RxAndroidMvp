/*
 *  Copyright (C) 2015 GuDong <gudong.name@gmail.com>
 *
 *  This file is part of GdTranslate
 *
 *  GdTranslate is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  GdTranslate is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with GdTranslate.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.tzarrb.rxandroidmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.lang.reflect.Method;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by GuDong on 1/28/16 11:35.
 * Contact with gudong.name@gmail.com.
 */
public abstract class BaseActivity<P extends BasePreseter> extends AppCompatActivity implements IBaseView{

    public Context context;
    public String activityName;
    protected boolean runActivityTasksFist;
    protected boolean isAcitivityDestoryed;

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());
        context = this;
        activityName = this.getClass().getName();
        isAcitivityDestoryed = false;
        init(savedInstanceState);
        init();

        mPresenter = initPresenter();

        mPresenter.attach(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if (containEventBusMethod()) {
            EventBus.getDefault().register(this);
        }
    }

    protected abstract int setLayoutResource();

    protected abstract void init();

    protected void init(Bundle savedInstanceState){}

    @Override
    protected void onResume() {
        super.onResume();
        runActivityTasksFist = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        runActivityTasksFist = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isAcitivityDestoryed = true;
        mPresenter.onDestroy();
        if (containEventBusMethod()) {
            EventBus.getDefault().unregister(this);
        }
        ButterKnife.unbind(this);
    }

    private boolean containEventBusMethod() {
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("onEvent"))
                return true;
        }
        return false;
    }

    protected void initActionBar(boolean homeButtonEnable,String title){
        getSupportActionBar().setHomeButtonEnabled(homeButtonEnable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeButtonEnable);
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化presenter
     * @return
     */
    protected abstract P initPresenter();
}
