package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDateStart(LocalDateTime.now());
        student.setFullName("Shmelev Artem");
        student.setGroup("group #1");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println("Student - " + student.getFullName() + "; group - " + student.getGroup()
                + "; date of start - " + student.getDateStart().format(formatter));
    }
}
