package com.xdxfw.vector;

public interface IVector {
    public IVector add(IVector other);
    public IVector sub(IVector other);
    public IVector mul(IVector other);
    public IVector div(IVector other);
    public double length();
    public IVector normalize();
}
