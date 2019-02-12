package com.example.wangyu.redevenlope;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Author wangyu1
 * Data 2019/1/10
 * Description
 **/
public class MyFramLayout extends ConstraintLayout {
    public MyFramLayout(@NonNull Context context) {
        this(context,null);
    }

    public MyFramLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
       this(context, attrs,0);
    }

    public MyFramLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        Path path = new Path();
        int w = this.getWidth();
        int h = this.getHeight();

        path.addRoundRect(new RectF(0, 0, w, h), 16, 16, Path.Direction.CW);
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

}
