package ru.job4j.inheritance;

public class Programmer extends Engineer{
    public Programmer(String name, String surname, String education, String birthday, int yearsExp, String langProg) {
        super(name, surname, education, birthday, yearsExp);
        this.langProg = langProg;
    }
    private String langProg;
    public void writeCode() {}
}