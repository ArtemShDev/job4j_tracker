package ru.job4j.inheritance;

public class Doctor extends Profession{
    public Doctor(String name, String surname, String education, String birthday, String profileDoc) {
        super(name, surname, education, birthday);
        this.profileDoc = profileDoc;
    }
    private String profileDoc;
    public Diagnosis heal(Pacient pacient) {
        Diagnosis diag = new Diagnosis();
        diag.readMedicalHistory(pacient);
        return diag;
    }
}
