package ru.job4j.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameContains = p -> p.getName().contains(key);
        Predicate<Person> phoneContains = p -> p.getPhone().contains(key);
        Predicate<Person> surnameContains = p -> p.getSurname().contains(key);
        Predicate<Person> addressContains = p -> p.getAddress().contains(key);
        Predicate<Person> combine = nameContains.or(phoneContains).or(surnameContains).or(addressContains);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}