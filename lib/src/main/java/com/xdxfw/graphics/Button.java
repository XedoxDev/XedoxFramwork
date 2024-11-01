package com.xdxfw.graphics;

import android.graphics.Canvas;
import android.media.metrics.Event;
import android.transition.Scene;
import android.view.MotionEvent;
import com.xdxfw.core.ScreenAdapter;

public class Button extends Object {

    private int width, height;
    private ScreenAdapter context;
    private boolean isPressed = false;
    private OnClick onClick;
    private OnTouch onTouch;

    public Button(ScreenAdapter context, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.context = context;
    }

    public Button(ScreenAdapter context, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.context = context;
    }

    private int defaultColor, pressedColor, currentColor;

    @Override
    public void display(Canvas canvas) {
        final MotionEvent event = context.getEvent();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (event.getX() < x
                    && event.getX() > x + width
                    && event.getY() > y
                    && event.getX() < y + height) {
                currentColor = pressedColor;
                isPressed = true;
                onTouch.onPressed();
            }
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            onTouch.onMoved();
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            currentColor = pressedColor;
            isPressed = false;
            onTouch.onReleased();
            if (event.getX() < x
                    && event.getX() > x + width
                    && event.getY() > y
                    && event.getX() < y + height) {
                onClick.onClick();
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
    }

    public int getPressedColor() {
        return this.pressedColor;
    }

    public void setPressedColor(int pressedColor) {
        this.pressedColor = pressedColor;
    }

    public static interface OnClick {
        public void onClick();
    }

    public static interface OnTouch {
        public void onPressed();

        public void onMoved();

        public void onReleased();
    }

    public boolean getIsPressed() {
        return this.isPressed;
    }

    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public OnClick getOnClick() {
        return this.onClick;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public OnTouch getOnTouch() {
        return this.onTouch;
    }

    public void setOnTouch(OnTouch onTouch) {
        this.onTouch = onTouch;
    }
}
