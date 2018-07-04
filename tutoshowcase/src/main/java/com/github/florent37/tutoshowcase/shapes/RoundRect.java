package com.github.florent37.tutoshowcase.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;

public class RoundRect extends Shape {

    private int x;
    private int y;
    private int width;
    private int height;
    private Float radius;
    public static final int BORDER_PADDING = 15;

    public RoundRect(int x, int y, int width, int height, @Nullable Float radius) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void drawOn(Canvas canvas) {
        if (isDisplayBorder()) {
            drawRoundedRect(canvas, getX() - BORDER_PADDING, getY() - BORDER_PADDING, getX() + getWidth() + BORDER_PADDING, getY() + getHeight() + BORDER_PADDING, getBorderPaint());
        }
        drawRoundedRect(canvas, getX(), getY(), getX() + getWidth(), getY() + getHeight(), paint);
    }

    protected void drawRoundedRect(Canvas canvas, float left, float top, float right, float bottom, Paint paint) {
        if (this.radius == null) {
            this.radius = (bottom - top) / 2;
        }

        RectF rectF = new RectF(left, top, right, bottom);
        canvas.drawRoundRect(rectF, this.radius, this.radius, paint);
    }
}
