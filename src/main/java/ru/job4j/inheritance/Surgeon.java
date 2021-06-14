package ru.job4j.inheritance;

public class Surgeon extends Doctor{
    public Surgeon(String name, String surname, String education, String birthday, String profileDoc) {
        super(name, surname, education, birthday, profileDoc);
    }
    public void operationsSurgeon(Pacient pacient) {
    }
}
