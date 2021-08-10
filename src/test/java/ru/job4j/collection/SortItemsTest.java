package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortItemsTest {
    @Test
    public void whenSortUpItemsById() {
        List<Item> in = new ArrayList<>();
        in.add(new Item("First", 1));
        in.add(new Item("Third", 3));
        in.add(new Item("Second", 2));
        in.sort(new SortItemsByIdUp());
        List<Item> expected = List.of(
                new Item("First", 1),
                new Item("Second", 2),
                new Item("Third", 3));
        assertThat(in, is(expected));
    }

    @Test
    public void whenSortDownItemsById() {
        List<Item> in = new ArrayList<>();
        in.add(new Item("First", 1));
        in.add(new Item("Third", 3));
        in.add(new Item("Second", 2));
        in.sort(new SortItemsByIdDown());
        List<Item> expected = List.of(
                new Item("Third", 3),
                new Item("Second", 2),
                new Item("First", 1));
        assertThat(in, is(expected));
    }

}