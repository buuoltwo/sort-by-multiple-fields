package com.github.hcsp.polymorphism;

import java.io.IOException;
import java.util.*;

public class Point implements Comparable{

    private final int x;
    private final int y;
    // 代表笛卡尔坐标系中的一个点
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    // 按照先x再y，从小到大的顺序排序
    // 例如排序后的结果应该是 (-1, 1) (1, -1) (2, -1) (2, 0) (2, 1)
    public static List<Point> sort(List<Point> points) {
        Collections.sort(points);
        return points;
    }

    public static void main(String[] args) throws IOException {
        List<Point> points =
                Arrays.asList(
                        new Point(2, 0),
                        new Point(-1, 1),
                        new Point(1, -1),
                        new Point(2, 1),
                        new Point(2, -1));
        System.out.println(Point.sort(points));
    }

    static int isSmaller(int a, int b) {
        if(a < b) return -1;
        if(a > b) return 1;
        return 0;

    }
    @Override
    public int compareTo(Object that) {
        if(that instanceof Point) {
            int seeX = isSmaller(getX(), ((Point)that).getX());
            if(seeX == 0) {
                return isSmaller(getY(),((Point)that).getY());
            }
            return seeX;
        }
    return 0;
    }
}
