package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsageToMap {
    public Map<String, Student> getStudents(List<Student> students) {
        return students.stream().distinct()
                .collect(Collectors.toMap(Student::getSurname, e -> e, (f, s) -> s));
    }


}
