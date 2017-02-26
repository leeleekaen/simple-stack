package com.zhuinden.simplestackdemonestedstack.presentation.paths.main.cloudsync.another.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.NestedStack;
import com.zhuinden.simplestackdemonestedstack.R;
import com.zhuinden.simplestackdemonestedstack.application.MainActivity;
import com.zhuinden.simplestackdemonestedstack.presentation.paths.main.cloudsync.another.internal2.Internal2Key;
import com.zhuinden.simplestackdemonestedstack.util.BackPressListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zhuinden on 2017.02.25..
 */

public class InternalView
        extends RelativeLayout
        implements BackPressListener {
    public InternalView(Context context) {
        super(context);
        init(context);
    }

    public InternalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InternalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(21)
    public InternalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    InternalKey internalKey;

    private void init(Context context) {
        if(!isInEditMode()) {
            this.internalKey = Backstack.getKey(context);
        }
    }

    NestedStack nestedStack;

    @BindView(R.id.another_text)
    TextView textView;

    @OnClick(R.id.another_back)
    public void backClicked() {
        if(!nestedStack.goBack()) {
            MainActivity.get(getContext()).onBackPressed();
        }
    }

    @OnClick(R.id.another_forward)
    public void forwardClicked() {
        nestedStack.getParent().goTo(Internal2Key.create());
    }


    @OnClick(R.id.internal_button)
    public void click() {
        Toast.makeText(getContext(), "Hello!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        nestedStack = Backstack.getNestedStack(getContext());
        Object key = Backstack.getKey(getContext());
        Log.i("LOL", "" + key);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
