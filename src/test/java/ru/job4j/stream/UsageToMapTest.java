package ru.job4j.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UsageToMapTest {
    @Test
    public void whenStudentsConvertToMapSecond() {
        List<Student> students = Arrays.asList(
                new Student(50, "Shmelev"),
                new Student(50, "Shmelev"),
                new Student(80, "Shmelev"),
                new Student(70, "Ivanov")
        );
        UsageToMap um = new UsageToMap();
        Map<String, Student> rsl = um.getStudents(students);
        Map<String, Student> expected = new TreeMap<>();
        expected.put("Shmelev", new Student(80, "Shmelev"));
        expected.put("Ivanov", new Student(70, "Ivanov"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenStudentsConvertToMapFirst() {
        List<Student> students = Arrays.asList(
                new Student(60, "Shmelev"),
                new Student(60, "Shmelev"),
                new Student(80, "Shmelev"),
                new Student(70, "Ivanov"),
                new Student(85, "Ivanov")
        );
        UsageToMap um = new UsageToMap();
        Map<String, Student> rsl = um.getStudents(students);
        Map<String, Student> expected = new TreeMap<>();
        expected.put("Shmelev", new Student(80, "Shmelev"));
        expected.put("Ivanov", new Student(85, "Ivanov"));
        assertThat(rsl, is(expected));
    }
}