package com.example.ball;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import java.util.jar.Attributes;

public class customView extends View {

    private Paint mPaint;
    private WindowManager wml;
    private int radius = 0;
    private int width = 0;
    private int height = 0;

    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ball);
        this.radius = ta.getInt(R.styleable.ball_radius,0);
        this.width = ta.getInt(R.styleable.ball_width, 0);
        this.height = ta.getInt(R.styleable.ball_hei, 0);

        ta.recycle();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" +this.height+this.radius+this.width);

    }
    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" +this.height+this.radius+this.width);

        onCreateBall(canvas);
//        invalidate();
    }

    private void onCreateBall(Canvas canvas) {
        if(this.radius > 0) {
            int radius = this.radius;
            int width = this.width;
            int height = this.height;
            if (this.radius > 150) return;
            int x = (int)Math.random() * (width - radius * 2);
            int y = (int)Math.random() * (height - radius * 2);

//        WindowManager wm = this.getsy
//
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

//        Canvas canvas = new Canvas();
//        canvas.drawRect(0,0,200,200,mPaint);
//        canvas.drawCircle(100, 100,100,mPaint);
//        onDraw();

        canvas.drawCircle(x, y, radius, mPaint);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" +this.height+this.radius+this.width);
        }
    }
}
