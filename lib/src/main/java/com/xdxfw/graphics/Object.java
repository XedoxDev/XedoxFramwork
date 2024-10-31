package com.xdxfw.graphics;

import android.graphics.Paint;
import com.xdxfw.core.IScreen;

public abstract class Object extends Paint {
    
    protected int x, y;
    protected IScreen context;
    
    public Object(IScreen context) {
        this.context = context;
        x = 0;
        y = 0;
    }

    public abstract void draw();
}
