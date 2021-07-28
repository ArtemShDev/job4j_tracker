package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        boolean canDrive = false;
        System.out.println("Calling the method \"drive\"");
    }

    @Override
    public void passengers(int passengers) {
        int chairs = passengers;
        System.out.println("Calling the method \"passengers\"");
    }

    @Override
    public double fill(double fuel) {
        return 0;
    }
}
