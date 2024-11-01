package com.xdxfw.vector;

package com.xdxfw.vector;

public class Vec3 implements IVector {

    public double x, y,z;

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    @Override
    public Vec3 add(IVector other) {
        Vec3 o = (Vec3) other;
        return new Vec3(x + o.x, y + o.y, z + o.z);
    }

    @Override
    public Vec3 sub(IVector other) {
        Vec3 o = (Vec3) other;
        return new Vec3(x - o.x, y - o.y, z - o.z);
    }

    @Override
    public Vec3 mul(IVector other) {
        Vec3 o = (Vec3) other;
        return new Vec3(x * o.x, y * o.y, z * o.z);
    }

    @Override
    public Vec3 div(IVector other) {
        Vec3 o = (Vec3) other;
        return new Vec3(x / o.x, y / o.y, z / o.z);
    }

    @Override
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    @Override
    public Vec3 normalize() {
        if(length()>0)
        return new Vec3(x / length(), y / length(), z / length());
        return new Vec3();
    }
}
