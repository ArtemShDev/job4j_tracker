package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String fullName;
    private String group;
    private LocalDateTime dateStart;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }
}
