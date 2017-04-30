package com.python.cat.slideswitchlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.apkfuns.logutils.LogUtils;

/**
 * packageName: com.python.cat.slideswitchlib
 * Created on 2017/4/30.
 *
 * @author cat
 */

public class SlideSwitch extends View {

    public enum State {
        OPEN, CLOSE
    }

    public interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isOpened   The new opened state of buttonView.
         */
        void onCheckedChanged(SlideSwitch buttonView, boolean isOpened);
    }

    private int currentX;
    private boolean isTouching = false;
    private int backGroundWidth;
    private int frontWidth;


    private Bitmap mBackBmp;
    private Bitmap mFrontBmp;

    private State switchState = State.CLOSE;

    private OnCheckedChangeListener mListener;

    @SuppressWarnings("unused")
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mListener = listener;
    }

    @SuppressWarnings("unused")
    public void setSwitchState(State state) {
        this.switchState = state;
        postInvalidate();
    }

    @SuppressWarnings("unused")
    public void setBackGroundBmp(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        if (bitmap != null) {
            this.mBackBmp = bitmap;
        }
        postInvalidate();
    }

    @SuppressWarnings("unused")
    public void setFrontBmp(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        if (bitmap != null) {
            this.mFrontBmp = bitmap;
        }
        postInvalidate();
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
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        backGroundWidth = mBackBmp.getWidth();
        frontWidth = mFrontBmp.getWidth();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mBackBmp.getWidth(), mBackBmp.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBackBmp, 0, 0, null);
        LogUtils.e("state = " + switchState);
        if (isTouching) {
            // ###################
            if (currentX < frontWidth / 2) {
                canvas.drawBitmap(mFrontBmp, 0, 0, null);
            } else if (currentX > backGroundWidth - frontWidth / 2) {
                canvas.drawBitmap(mFrontBmp, backGroundWidth - frontWidth, 0, null);
            } else {
                canvas.drawBitmap(mFrontBmp, currentX - frontWidth / 2, 0, null);
            }
        } else {
            switch (switchState) {
                case OPEN:
                    canvas.drawBitmap(mFrontBmp, backGroundWidth - frontWidth, 0, null);
                    break;
                case CLOSE:
                default:
                    canvas.drawBitmap(mFrontBmp, 0, 0, null);
                    break;
            }

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = Math.round(event.getX());
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isTouching = true;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                isTouching = false;
                // change state !
                if (currentX > backGroundWidth / 2) {
                    switchState = State.OPEN;
                } else {
                    switchState = State.CLOSE;
                }
                if (mListener != null) {
                    mListener.onCheckedChanged(this, switchState == State.OPEN);
                }
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

}
