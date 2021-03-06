package com.example.ball;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class CanvasDemoActivity extends Activity {
//    private Paint mPaint;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new CustomView1(this));

    }

    /**
     * 使用内部类 自定义一个简单的View
     *
     * @author Administrator
     */
    class CustomView1 extends View {

        private Paint mPaint;

        public CustomView1(Context context) {
            super(context);
//            paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
//            paint.setColor(Color.YELLOW);
//            paint.setStrokeJoin(Paint.Join.ROUND);
//            paint.setStrokeCap(Paint.Cap.ROUND);
//            paint.setStrokeWidth(3);
        }

        //在这里我们将测试canvas提供的绘制图形方法
        @Override
        protected void onDraw(Canvas canvas) {
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
//        mPaint.setColor(black);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(100, 100,100,mPaint);
        }

    }
}