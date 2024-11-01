package com.xdxfw.graphics;

import android.graphics.Canvas;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shape extends Object {

    private List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
        init();
    }

    public Shape(Point... points) {
        this.points = Arrays.asList(points);
        init();
    }

    public Shape(int... points) {
        this.points = new ArrayList<>();
        for (int i = 0; i < points.length; i += 2) {
            try {
                this.points.add(new Point(points[i], points[i + 1]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        init();
    }

    public Shape() {
        this.points = new ArrayList<>();
        init();
    }

    private void init() {
        shape = new Path();
    }

    private Path shape;

    @Override
    public void display(Canvas canvas) {
        shape.reset();
        if (points.size() > 0) shape.moveTo(x + points.get(0).x, y + points.get(0).y);
        if (points.size() > 1) {
            for (Point point : points) {
                shape.lineTo( x + point.x, y + point.y);
            }
        }
        canvas.drawPath(shape, this);
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this.x = 0;
            this.y = 0;
        }
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Path getShape() {
        return this.shape;
    }

    public void setShape(Path shape) {
        this.shape = shape;
    }
    
    public void add(Point point) {
        points.add(point);
    }
    
    public void add(Point... point) {
        for(Point p : points) {
        	points.add(p);
        }
    }
    
    public void remove(int i) {
        points.remove(i);
    }
    
    public Point get(int i) {
        return points.get(i);
    }
}
