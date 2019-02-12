package com.example.wangyu.redevenlope;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author wangyu1
 * Data 2019/1/8
 * Description
 **/
public class EnvelopeView extends View {

    private Paint mPaint;
    private int viewWidth;
    private int viewHeight;
    private float deg;

    public EnvelopeView(Context context) {
        this(context, null);
    }

    public EnvelopeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EnvelopeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        Path mPath = new Path();
        RectF rectF = new RectF(10, 10, getWidth() - 10, getHeight() / deg);
        mPath.addRoundRect(rectF, 16, 16, Path.Direction.CW);
        mPath.moveTo(getWidth() - 22, getHeight() / deg);
        mPath.quadTo(getWidth() / 2, getHeight() /deg+300 , 22, getHeight() / deg);
        canvas.drawPath(mPath, mPaint);

    }

    public void startAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.5f, 4.0f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                deg = (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(30000);
        valueAnimator.start();
    }
}
