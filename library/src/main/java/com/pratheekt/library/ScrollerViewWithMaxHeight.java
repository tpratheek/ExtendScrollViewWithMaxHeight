package com.pratheekt.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

public class ScrollerViewWithMaxHeight extends ScrollView {

    private static final int WITHOUTMAXVALUE=-1;

    private int maxY = WITHOUTMAXVALUE;

    public ScrollerViewWithMaxHeight(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styleAtribute = context.getTheme().obtainStyledAttributes(attrs,R.styleable.ScrollViewWithMaxHeight,0,0);
        try {
            setMaxHeight(styleAtribute.getDimensionPixelSize(R.styleable.ScrollViewWithMaxHeight_maximumHeight, 0));

        } finally {
            styleAtribute.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            int YSize = MeasureSpec.getSize(heightMeasureSpec);
            if (maxY != WITHOUTMAXVALUE
                    && YSize > maxY) {
                YSize = maxY;
            }
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(YSize, MeasureSpec.AT_MOST);
            getLayoutParams().height = YSize;
        } catch (Exception e) {
            Log.e("onMesure", "Error forcing height", e);
        } finally {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void setMaxHeight(int dimensionPixelSize) {
        maxY = dimensionPixelSize;
    }


}
