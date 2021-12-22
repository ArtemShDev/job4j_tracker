package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void executeDone() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        for (Item item : tracker.findAll()) {
            tracker.delete(item.getId());
        }
        Item item = new Item("Item for find");
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item for find");
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===="
                + ln + item + ln));
    }

    @Test
    public void executeFalse() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.add(new Item("Item for find"));
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("null");
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===="
                + ln + "Заявки с именем: null не найдены." + ln));
    }
}