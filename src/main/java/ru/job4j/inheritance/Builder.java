package ru.job4j.inheritance;

public class Builder extends Engineer{
    public Builder(String name, String surname, String education, String birthday, int yearsExp, int classBuilder) {
        super(name, surname, education, birthday, yearsExp);
        this.classBuilder = classBuilder;
    }
    private int classBuilder;
    public boolean agreeBuild(Proj proj){
        return false;
    }
}
