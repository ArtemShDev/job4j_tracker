package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void when11to20then141() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        double expected = 1.41;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when10to20then1() {
        Point a = new Point(1, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        double expected = 1.0;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when11to23then223() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 3);
        double out = a.distance(b);
        double expected = 2.23;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when111to232then245() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(2, 3, 2);
        double out = a.distance3d(b);
        double expected = 2.45;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when111to222then173() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(2, 2, 2);
        double out = a.distance3d(b);
        double expected = 1.73;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when123to213then141() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(2, 1, 3);
        double out = a.distance3d(b);
        double expected = 1.41;
        Assert.assertEquals(expected, out, 0.01);
    }
}