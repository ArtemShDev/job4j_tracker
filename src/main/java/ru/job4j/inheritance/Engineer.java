package ru.job4j.inheritance;

public class Engineer extends Profession {

    private int yearsExp;

    public Engineer(String name, String surname, String education, String birthday, int yearsExp) {
        super(name, surname, education, birthday);
        this.yearsExp = yearsExp;
    }

    public Decision analysisP(Proj proj) {
        Decision dec = new Decision();
        dec.read(proj);
        return dec;
    }
}
