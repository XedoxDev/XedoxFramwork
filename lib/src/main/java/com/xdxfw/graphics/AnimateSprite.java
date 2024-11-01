package com.xdxfw.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import com.xdxfw.core.ScreenAdapter;
import com.xdxfw.io.SpriteManager;
import java.util.List;

public class AnimateSprite extends Sprite {

    private List<Bitmap> sprites;

    private boolean isAnimating = false;
    private boolean threadLive = true;
    private long delay = 500;
    private int currentSprite = 0;

    private Thread updateThread =
            new Thread() {
                @Override
                public void run() {
                    while (threadLive) {
                        if (isAnimating) {
                            try {
                                sleep(delay);
                                synchronized (getSprite()) {
                                    setSprite(sprites.get(currentSprite));
                                    currentSprite++;
                                    if (currentSprite > sprites.size()) {
                                        currentSprite = 0;
                                    }
                                }
                            } catch (Exception err) {
                                err.printStackTrace();
                            }
                        }
                    }
                }
            };

    public AnimateSprite() {
        super();
        updateThread.start();
    }

    public void destroy() {
        try {
            sprites = null;
            threadLive = false;
            isAnimating = false;
            updateThread.join();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public List<Bitmap> getSprites() {
        return this.sprites;
    }

    public void setSprites(List<Bitmap> sprites) {
        this.sprites = sprites;
    }

    public boolean getIsAnimating() {
        return this.isAnimating;
    }

    public void setIsAnimating(boolean isAnimating) {
        this.isAnimating = isAnimating;
    }

    public long getDelay() {
        return this.delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public int getCurrentSprite() {
        return this.currentSprite;
    }

    public void setCurrentSprite(int currentSprite) {
        this.currentSprite = currentSprite;
    }

    public Thread getUpdateThread() {
        return this.updateThread;
    }

    public void setUpdateThread(Thread updateThread) {
        this.updateThread = updateThread;
    }
    
    public void add(Bitmap sprite) {
        sprites.add(sprite);
    }
    
    public Bitmap get(int i) {
        return sprites.get(i);
    }
    
    public void add(Bitmap... sprites) {
        for(Bitmap sprite : sprites) {
        	this.sprites.add(sprite);
        }
    }
    
    public void add(ScreenAdapter context, String... names) {
        SpriteManager sm = new SpriteManager();
        for(String name : names) {
        	sprites.add(sm.readSprite(context.getView().getContext(), name));
        }
    }
    
    public void remove(int i) {
        sprites.remove(i);
    }
} 
