package com.xdxfw.core;

import com.xdxfw.graphics.Object;
import java.util.ArrayList;
import java.util.List;

public class RenderManager {

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
}
