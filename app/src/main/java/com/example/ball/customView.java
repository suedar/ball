package com.example.ball;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class customView extends View {

    private Paint mPaint;
    private ValueAnimator mAnimator;
    private WindowManager wml;
    private int radius = 0;
    private int x = 0;
    private int y = 0;
    private int width;
    private int height;
    private int vx = 10;//小球x轴速度；
    private int vy = 10; //小球y轴速度
    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public customView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        onCreateBall(canvas);
    }

    public void fresh(final int w, final int h, int r) {
        if (r > 150) return;
        radius = (int)r;
        width = w;
        height = h - 200;
        x = (int)(Math.random() * (width - radius));
        y = (int)(Math.random() * (height - radius));

        if (x < radius) x = radius;
        if (y < radius) y = radius;


        mAnimator = ValueAnimator.ofFloat(0, 1);
        mAnimator.setRepeatCount(-1);
        mAnimator.setDuration(1000);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBall();
                invalidate();
            }
        });
        mAnimator.start();
    }

    private void updateBall() {
        x += vx;
        y += vy;
        if (x > (width - radius)) {
            vx = -vx;
        }
        if (x < radius) {
            vx = -vx;
        }
        if (y > (height - radius)) {
            vy = -vy;
        }
        if (y < radius) {
            vy = -vy;
        }
    }

    private void onCreateBall(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

        System.out.println(">>>>>>>>>>>>"+x+y+radius);

        if (radius!=0) {
            canvas.drawCircle(x, y, radius, mPaint);
        }

    }
}
