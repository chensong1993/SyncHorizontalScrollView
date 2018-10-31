package com.shanghai.flexiblelibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * @author chensong
 * @date 2018/10/31 13:27
 */
public class SyncHorizontalScrollView extends HorizontalScrollView {
    private View mView, mView1, mView2, mView3, mView4;

    public SyncHorizontalScrollView(Context context) {
        super(context);
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //设置控件滚动监听，得到滚动的距离，然后让传进来的view也设置相同的滚动具体
        if (mView != null) {
            mView.scrollTo(l, t);
        }
        if (mView1 != null) {
            mView1.scrollTo(l, t);
        }
        if (mView2 != null) {
            mView2.scrollTo(l, t);
        }
        if (mView3 != null) {
            mView3.scrollTo(l, t);
        }
        if (mView4 != null) {
            mView4.scrollTo(l, t);
        }
    }

    /**
     * 设置跟它联动的view
     *
     * @param
     */

    public void setScrollView(View view) {
        mView = view;
    }

    public void setScrollView(View view, View view1, View view2) {
        mView = view;
        mView1 = view1;
        mView2 = view2;

    }

    public void setScrollView(View view, View view1, View view2, View view3) {
        mView = view;
        mView1 = view1;
        mView2 = view2;
        mView3 = view3;
    }

    public void setScrollView(View view, View view1, View view2, View view3, View view4) {
        mView = view;
        mView1 = view1;
        mView2 = view2;
        mView3 = view3;
        mView4 = view4;
    }
}
