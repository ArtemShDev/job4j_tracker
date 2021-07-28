package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
    }

    public static void main(String[] args) {
        Error err = new Error();
        err.printInfo();
        Error err2 = new Error(true, 1, "Delivered");
        err2.printInfo();
        Error err3 = new Error(false, -1, "error");
        err3.printInfo();
    }
}
