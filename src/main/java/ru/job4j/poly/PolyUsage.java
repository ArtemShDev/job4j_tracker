package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle busFirst = new BusInt();
        Vehicle trainFirst = new Train();
        Vehicle plainFirst = new Plain();
        Vehicle busSecond = new BusInt();
        Vehicle trainSecond = new Train();
        Vehicle plainSecond = new Plain();
        Vehicle[] vehicles = new Vehicle[]{busFirst, trainFirst, plainFirst, trainSecond, busSecond, plainSecond};
        for (Vehicle a : vehicles) {
            a.move();
            System.out.println(a.countOfSeats());
        }
    }
}
