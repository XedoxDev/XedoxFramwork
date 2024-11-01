package com.xdxfw.core;

import android.graphics.Paint;
import com.xdxfw.graphics.Object;
import java.util.ArrayList;
import java.util.List;

public class RenderManager extends Paint {

    private ScreenAdapter context;
    private List<Object> objects;

    public RenderManager(ScreenAdapter context) {
        this.context = context;
        objects = new ArrayList<>();
    }

    public void display(Object obj, int x, int y) {
        obj.setX(x);
        obj.setY(y);
        obj.display(context.getCanvas());
    }

    public void display(Object obj) {
        obj.display(context.getCanvas());
    }

    public void displayObjects() {
        for (Object obj : objects) {
            obj.display(context.getCanvas());
        }
    }

    public void addObject(Object obj) {
        objects.add(obj);
    }

    public void removeObject(int i) {
        objects.remove(i);
    }

    public ScreenAdapter getContext() {
        return this.context;
    }

    public void setContext(ScreenAdapter context) {
        this.context = context;
    }

    public List<Object> getObjects() {
        return this.objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public void rect(float x, float y, float width, float height) {
        context.getCanvas().drawRect(x, y, x + width, y + height, this);
    }
    
    public void circle(float x, float y, float r) {
        context.getCanvas().drawCircle(x, y, r, this);
    }
    
    public void line(float x1, float y1, float x2, float y2) {
        context.getCanvas().drawLine(x1, y1, x2, y2, this);
    }
}
