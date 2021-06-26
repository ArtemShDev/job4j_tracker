package ru.job4j.poly;

public class Bus implements Transport{

    @Override
    public void drive() {
        boolean canDrive = false;
    }

    @Override
    public void passengers(int passengers) {
        int chairs = passengers;
    }

    @Override
    public double fill(double fuel) {
        return 0;
    }
}
