package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Art", "Shm", "777777", "MscReg")
        );
        ArrayList<Person> persons = phones.find("Petr");
        ArrayList<Person> persons2 = phones.find("Shm");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
        assertThat(persons2.get(0).getName(), is("Art"));
    }
}