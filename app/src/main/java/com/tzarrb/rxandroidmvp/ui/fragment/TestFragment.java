package com.tzarrb.rxandroidmvp.ui.fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.tzarrb.rxandroidmvp.R;
import com.tzarrb.rxandroidmvp.base.BaseFragment;
import com.tzarrb.rxandroidmvp.base.BasePresenter;
import com.tzarrb.rxandroidmvp.http.retrofit.MySubscriber;
import com.tzarrb.rxandroidmvp.utils.L;
import com.tzarrb.rxandroidmvp.utils.T;
import com.tzarrb.rxandroidmvp.utils.rxBindingUtils;

import butterknife.Bind;
import rx.Observable;
import rx.functions.Func3;

import static android.text.TextUtils.isEmpty;

/**
 * Created by ivan on 2016/7/6.
 */
@SuppressWarnings("ALL")
public class TestFragment extends BaseFragment implements rxBindingUtils.RxBinding, Func3Interface {

    @Bind(R.id.et1)
    EditText et1;
    @Bind(R.id.et2)
    EditText et2;
    @Bind(R.id.et3)
    EditText et3;
    @Bind(R.id.btn)
    Button btn;

    private rx.Observable<CharSequence> oneEditText;
    private rx.Observable<CharSequence> twoEditText;
    private rx.Observable<CharSequence> threeEditText;

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_test;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void init() {
        btn.setEnabled(false);
        oneEditText = RxTextView.textChanges(et1).skip(1);
        twoEditText = RxTextView.textChanges(et2).skip(1);
        threeEditText = RxTextView.textChanges(et3).skip(1);
        rxBindingUtils.clicks(btn, this);
        test(this);
    }

    private void test(final Func3Interface func3Interface) {
        Observable.combineLatest(oneEditText, twoEditText, threeEditText,
            new Func3<CharSequence, CharSequence, CharSequence, Boolean>() {
                @Override
                public Boolean call(CharSequence charSequenceEt1, CharSequence charSequenceEt2, CharSequence charSequenceEt3) {

                    return func3Interface.et(charSequenceEt1, charSequenceEt2, charSequenceEt3);
                }
            })
            .subscribe(new MySubscriber<Boolean>() {
                @Override
                public void onNext(Boolean aBoolean) {
                    L.i("TestFragment", aBoolean + "");
                    if (aBoolean) {
                        btn.setEnabled(true);
                    } else {
                        btn.setEnabled(false);
                    }
                }
            });
    }

    @Override
    public void clicks() {
        L.i("TestFragment", "被点击了");
        T.showShort(mContext, et1.getText().toString() + "+" + et2.getText().toString() + "+" + et3.getText().toString());
    }

    @Override
    public boolean et(CharSequence charSequenceEt1, CharSequence charSequenceEt2, CharSequence charSequenceEt3) {
        boolean et1Text = !isEmpty(charSequenceEt1);
        boolean et2Text = !isEmpty(charSequenceEt2);
        boolean et3Text = !isEmpty(charSequenceEt3);
        if (!et1Text) {
            et1.setHint("不能为空");
        }
        if (!et2Text) {
            et2.setHint("不能为空");
        }
        if (!et3Text) {
            et3.setHint("不能为空");
        }
        L.i("TestFragment", "et1Text   " + et1.getText().toString().trim());
        L.i("TestFragment", "et2Text   " + et2.getText().toString().trim());
        L.i("TestFragment", "et3Text   " + et3.getText().toString().trim());
        return et1Text && et2Text && et3Text;
    }
}

interface Func3Interface {
    boolean et(CharSequence charSequenceEt1, CharSequence charSequenceEt2, CharSequence charSequenceEt3);
}
