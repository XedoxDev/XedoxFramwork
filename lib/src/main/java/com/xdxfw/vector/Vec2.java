package com.xdxfw.vector;

public class Vec2 implements IVector {

    public double x, y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2() {
        this.x = 0.0;
        this.y = 0.0;
    }

    @Override
    public Vec2 add(IVector other) {
        Vec2 o = (Vec2) other;
        return new Vec2(x + o.x, y + o.y);
    }

    @Override
    public Vec2 sub(IVector other) {
        Vec2 o = (Vec2) other;
        return new Vec2(x - o.x, y - o.y);
    }

    @Override
    public Vec2 mul(IVector other) {
        Vec2 o = (Vec2) other;
        return new Vec2(x * o.x, y * o.y);
    }

    @Override
    public Vec2 div(IVector other) {
        Vec2 o = (Vec2) other;
        return new Vec2(x / o.x, y / o.y);
    }

    @Override
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public Vec2 normalize() {
        return new Vec2(x / length(), y / length());
    }
}
