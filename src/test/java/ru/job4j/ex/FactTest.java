package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcMinus() {
       int rsl = new Fact().calc(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcMinus2() {
        int rsl = new Fact().calc(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcMinus0() {
        int rsl = new Fact().calc(-1);
    }
}