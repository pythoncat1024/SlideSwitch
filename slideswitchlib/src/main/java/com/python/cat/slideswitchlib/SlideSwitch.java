package com.python.cat.slideswitchlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * packageName: com.python.cat.slideswitchlib
 * Created on 2017/4/30.
 *
 * @author cat
 */

public class SlideSwitch extends View {
    private Bitmap mBackBmp;
    private Bitmap mFrontBmp;

    public void setBackGroundBmp(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        if (bitmap != null) {
            this.mBackBmp = bitmap;
        }
    }

    public void setFrontBmp(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        if (bitmap != null) {
            this.mFrontBmp = bitmap;
        }
    }

    public SlideSwitch(Context context) {
        this(context, null);
    }

    public SlideSwitch(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideSwitch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mFrontBmp = BitmapFactory.decodeResource(getResources(), R.drawable.slide_front);
        this.mBackBmp = BitmapFactory.decodeResource(getResources(), R.drawable.switch_background);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mBackBmp.getWidth(), mBackBmp.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBackBmp, 0, 0, null);
        canvas.drawBitmap(mFrontBmp, 0, 0, null);
    }


}
