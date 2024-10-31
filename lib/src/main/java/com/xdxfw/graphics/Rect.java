package com.xdxfw.graphics;

import com.xdxfw.core.IScreen;

public class Rect extends Object {

    private int x, y;
    private int width, height;

    public Rect(IScreen context, int x, int y, int width, int height) {
        super(context);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
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

    @Override
    public void draw() {
        context.getCanvas().drawRect(x, y, x + width, y + height, this);
    }
}
