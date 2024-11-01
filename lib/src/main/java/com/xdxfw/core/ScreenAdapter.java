package com.xdxfw.core;

import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class ScreenAdapter {

    protected XSurfaceView view;
    protected MotionEvent event;
    protected Canvas canvas;

    public void start() {}

    public void render(Canvas canvas) {}

    public void setScreen(ScreenAdapter newScreen) {
        view.setScreen(newScreen);
    }

    public void touchEvent(MotionEvent event, int x, int y) {}

    public void pressed(MotionEvent event, int x, int y) {}

    public void moved(MotionEvent event, int x, int y) {}

    public void released(MotionEvent event, int x, int y) {}

    public MotionEvent getEvent() {
        return this.event;
    }

    public void setEvent(MotionEvent event) {
        this.event = event;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public XSurfaceView getView() {
        return this.view;
    }

    public void setView(XSurfaceView view) {
        this.view = view;
    }
}
