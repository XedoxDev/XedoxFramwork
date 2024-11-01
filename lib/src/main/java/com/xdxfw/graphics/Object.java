package com.xdxfw.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public abstract class Object extends Paint implements Serializable {

    protected int x, y;

    public Object() {
        x = 0;
        y = 0;
    }

    public abstract void display(Canvas canvas);

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
    
    public void serialize(String name) {
        try (FileOutputStream fileOut = new FileOutputStream(name + ".ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Object deserialize(String name) {
        try (FileInputStream fileIn = new FileInputStream(name + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            Object obj = (Object) in.readObject();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
