package com.tzarrb.rxandroidmvp.base;

/**
 * Created by ${ldl} on  2016/6/4.
 * 11:13
 */
public abstract class BasePreseter<V extends IBaseView> {
    public V mView;

    public void onCreate(){}

    public void attach(V mView){
        this.mView = mView;
    }

    public  void onDestroy(){
        mView=null;
    }

}
