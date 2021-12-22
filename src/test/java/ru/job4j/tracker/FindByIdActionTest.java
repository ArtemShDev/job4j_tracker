package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void executeDone() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.init();
        Item item = new Item("New item for find by ID");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===="
                + ln + item + ln));
    }

    @Test
    public void executeFalse() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.init();
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===="
                + ln + "Заявка с введенным id: 0 не найдена." + ln));
    }
}