package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int classBuilder;

    public Builder(String name, String surname, String education, String birthday, int yearsExp,
             int classBuilder) {
        super(name, surname, education, birthday, yearsExp);
        this.classBuilder = classBuilder;
    }

    public boolean agreeBuild(Proj proj) {
        return false;
    }
}
