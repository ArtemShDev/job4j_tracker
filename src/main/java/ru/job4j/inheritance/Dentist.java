package ru.job4j.inheritance;

public class Dentist extends Doctor{
    public Dentist(String name, String surname, String education, String birthday, String profileDoc) {
        super(name, surname, education, birthday, profileDoc);
    }
    public void operationsDentist(Pacient pacient) {
    }
}
