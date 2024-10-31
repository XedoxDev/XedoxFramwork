package com.xdxfw.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.xdxfw.core.IScreen;

public class Sprite extends Object {

    private int x, y;
    private Bitmap sprite;

    public Sprite(IScreen context) {
        super(context);
    }

    @Override
    public void draw() {
        context.getCanvas().drawBitmap(sprite, x, y, this);
    }

    public void loadBitmap(Context context, String name) {
        try {
            sprite = BitmapFactory.decodeStream(context.getAssets().open(name));
        } catch (Exception err) {
            err.printStackTrace();
        }
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

    public Bitmap getSprite() {
        return this.sprite;
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }
}
