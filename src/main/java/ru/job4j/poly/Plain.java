package ru.job4j.poly;

public class Plain implements Vehicle {
    @Override
    public void move() {
        System.out.println("the " + getClass().getSimpleName() + " is flying");
    }

    @Override
    public int countOfSeats() {
        return 400;
    }
}
