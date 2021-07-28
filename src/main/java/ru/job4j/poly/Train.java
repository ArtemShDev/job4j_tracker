package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("the " + getClass().getSimpleName() + " is running by rails");
    }

    @Override
    public int countOfSeats() {
        return 1500;
    }
}
