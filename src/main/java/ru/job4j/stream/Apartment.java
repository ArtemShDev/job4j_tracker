package ru.job4j.stream;

import java.util.Date;

public class Apartment {
    private int countOfPersons;
    private String nameOfBooked;
    private int numberOfRooms;
    private int daysForRent;
    private double sum;
    private Date checkinDate;

    public static void main(String[] args) {
        Apartment app = new Builder().buildCountOfPersons(2)
                .buildDaysForRent(2)
                .buildNameOfBooked("Ivan")
                .buildNumberOfRooms(15)
                .buildCheckinDate(new Date())
                .buildSum(5000.0)
                .build();
        System.out.println(app);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "countOfPersons=" + countOfPersons +
                ", nameOfBooked='" + nameOfBooked + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", daysForRent=" + daysForRent +
                ", sum=" + sum +
                ", checkinDate=" + checkinDate +
                '}';
    }

    static class Builder {
        private int countOfPersons;
        private String nameOfBooked;
        private int numberOfRooms;
        private int daysForRent;
        private double sum;
        private Date checkinDate;

        Builder buildNameOfBooked(String nameOfBooked) {
            this.nameOfBooked = nameOfBooked;
            return this;
        }

        Builder buildCountOfPersons(int countOfPersons) {
            this.countOfPersons = countOfPersons;
            return this;
        }

        Builder buildNumberOfRooms(int numberOfRooms) {
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        Builder buildDaysForRent(int daysForRent) {
            this.daysForRent = daysForRent;
            return this;
        }

        Builder buildSum(double sum) {
            this.sum = sum;
            return this;
        }

        Builder buildCheckinDate(Date checkinDate) {
            this.checkinDate = checkinDate;
            return this;
        }

        Apartment build() {
            Apartment app = new Apartment();
            app.countOfPersons = countOfPersons;
            app.nameOfBooked = nameOfBooked;
            app.numberOfRooms = numberOfRooms;
            app.daysForRent = daysForRent;
            app.sum = sum;
            app.checkinDate = checkinDate;
            return app;
        }
    }
}
