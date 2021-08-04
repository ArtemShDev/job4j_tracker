package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void when3ProfilesThen3Addresses() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Msk", "Ryabinovaya str.", 25, 55)),
                new Profile(new Address("Msk", "Ryabinovaya str.", 32, 80)),
                new Profile(new Address("Mozhaisk", "Zavodskaya str.", 1, 12))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Msk", "Ryabinovaya str.", 25, 55));
        expected.add(new Address("Msk", "Ryabinovaya str.", 32, 80));
        expected.add(new Address("Mozhaisk", "Zavodskaya str.", 1, 12));
        assertThat(rsl, is(expected));
    }

    @Test
    public void when2ProfilesThen2Addresses() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Msk", "Ryabinovaya str.", 25, 55)),
                new Profile(new Address("Mozhaisk", "Zavodskaya str.", 1, 12))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Msk", "Ryabinovaya str.", 25, 55));
        expected.add(new Address("Mozhaisk", "Zavodskaya str.", 1, 12));
        assertThat(rsl, is(expected));
    }

}