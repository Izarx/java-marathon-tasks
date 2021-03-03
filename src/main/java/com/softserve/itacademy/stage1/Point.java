package com.softserve.itacademy.stage1;

public class Point {
    private int x;
    private int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair () {
        return new int[] {this.x, this.y};
    }

    public double distance(int x, int y) {
        int diffX = this.x - x;
        int diffY = this.y - y;
        return Math.sqrt((diffX*diffX)+(diffY*diffY));
    }

    public double distance(Point point) {
        return distance(point.x, point.y);
    }

    public double distance() {
        return distance(0, 0);
    }
}
