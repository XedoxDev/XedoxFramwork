package com.xdxfw.io;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SpriteManager {
    public Bitmap readSprite(Context context, String spriteName) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(spriteName));
        } catch (Exception e) {
            return Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888);
        }
    }
    
    public Bitmap readSprite(Context context, String spriteName, Bitmap.Config type) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(spriteName));
        } catch (Exception e) {
            return Bitmap.createBitmap(0, 0, type);
        }
    }
}
