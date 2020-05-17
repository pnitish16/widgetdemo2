package com.nitish.cardviewwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;


/**
 */

public class CustomImageView extends AppCompatImageView {

    float aspect_ratio = 0.0f;

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView, 0, 0);
        try {
            aspect_ratio = ta.getFloat(R.styleable.CustomImageView_aspect_ratio, 0.0f);
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        if(aspect_ratio != 0) {
            setMeasuredDimension(width, (int) (width / aspect_ratio));
        }else{
            setMeasuredDimension(width, (int) (width / 2.78));
        }
    }
}
