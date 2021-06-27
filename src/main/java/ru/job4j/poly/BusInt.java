package ru.job4j.poly;

public class BusInt implements Vehicle{
    @Override
    public void move() {
        System.out.println("the " + getClass().getSimpleName() + " is running");
    }

    @Override
    public int countOfSeats() {
        return 70;
    }
}
