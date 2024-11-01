package com.xdxfw.core;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class XSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private ScreenAdapter screen;
    private RenderThread thread;

    public XSurfaceView(Context context, ScreenAdapter startScreen) {
        super(context);
        this.screen = startScreen;
        getHolder().addCallback(this);
    }

    public ScreenAdapter getScreen() {
        return this.screen;
    }

    public void setScreen(ScreenAdapter screen) {
        this.screen = screen;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new RenderThread(this);
        thread.setIsRun(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int arg1, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        screen.setEvent(event);
        screen.touchEvent(event, (int) event.getX(), (int) event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                screen.pressed(event, (int) event.getX(), (int) event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                screen.pressed(event, (int) event.getX(), (int) event.getY());
                break;
            case MotionEvent.ACTION_UP:
                screen.pressed(event, (int) event.getX(), (int) event.getY());
                break;
        }
        return true;
    }
}
