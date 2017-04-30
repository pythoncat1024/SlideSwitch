package com.python.cat.slideswitchlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * packageName: com.python.cat.slideswitchlib
 * Created on 2017/4/30.
 *
 * @author cat
 */

public class SlideSwitch extends View {

    private int currentX;
    private boolean isTouching = false;

    private enum State {
        OPEN, CLOSE
    }

    private Bitmap mBackBmp;
    private Bitmap mFrontBmp;

    private State switchState = State.CLOSE;

    public void setSwitchState(State state) {
        this.switchState = state;
    }

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

        int backGroundWidth = mBackBmp.getWidth();
        int frontWidth = mFrontBmp.getWidth();
        if (isTouching) {
            switch (switchState) {
                case OPEN:
                    // todo
                    break;
                case CLOSE:
                default:
                    // todo
                    if (currentX < frontWidth / 2) {
                        canvas.drawBitmap(mFrontBmp, 0, 0, null);
                    } else if (currentX > backGroundWidth - frontWidth / 2) {
                        canvas.drawBitmap(mFrontBmp, backGroundWidth - frontWidth, 0, null);
                    } else {
                        canvas.drawBitmap(mFrontBmp, currentX - frontWidth / 2, 0, null);
                    }

                    break;
            }
        } else {
            if (currentX < backGroundWidth / 2) {
                canvas.drawBitmap(mFrontBmp, 0, 0, null);
            } else {
                canvas.drawBitmap(mFrontBmp, backGroundWidth - frontWidth, 0, null);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isTouching = true;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                isTouching = false;
                break;
            default:
                break;
        }
        currentX = Math.round(event.getX());
        invalidate();
        return true;
    }
}
