package com.xdxfw.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.Image;

public class Sprite extends Object {

    private int x, y;
    private Bitmap sprite;
    private float angle;
    private boolean visible;

    public Sprite() {
        super();
        angle = 0;
        visible = true;
    }

    public void setSize(int width, int height) {
        sprite.setWidth(width);
        sprite.setHeight(height);
    }

    public void setWidth(int width) {
        sprite.setWidth(width);
    }

    public void setHeight(int height) {
        sprite.setHeight(height);
    }

    public Bitmap getSprite() {
        return this.sprite;
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    @Override
    public void display(Canvas canvas) {
        if (visible) {
            Matrix oldMtrix = null;
            Matrix newMatrix = null;
            canvas.getMatrix(oldMtrix);
            canvas.getMatrix(newMatrix);
            newMatrix.setRotate(angle, x, y);
            canvas.setMatrix(newMatrix);
            canvas.drawBitmap(sprite, x, y, this);
            canvas.setMatrix(oldMtrix);
        }
    }

    public float getAngle() {
        return this.angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
