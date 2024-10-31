package com.xdxfw.core;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class RenderThread extends Thread {

    private boolean isRun;
    private SurfaceHolder holder;
    private XSurfaceView view;

    public RenderThread(XSurfaceView view) {
        this.view = view;
        this.holder = view.getHolder();
    }

    @Override
    public void run() {
        Canvas canvas = null;
        view.getScreen().start();
        while (isRun) {
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    synchronized (holder) {
                        view.getScreen().setCanvas(canvas);
                        view.getScreen().render(canvas);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void setIsRun(boolean isRun) {
        this.isRun = isRun;
    }

    public void stopThread() {
        isRun = false;
        try {
        	join();
        } catch(Exception err) {
        	
        }
    }
}
