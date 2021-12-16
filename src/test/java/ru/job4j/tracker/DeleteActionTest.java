package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void executeDone() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        for (Item item : tracker.findAll()) {
            tracker.delete(item.getId());
        }
        Item item = new Item("New item for delete");
        tracker.add(item);
        DeleteAction del = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===="
                + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void executeFalse() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.add(new Item("New item for delete"));
        DeleteAction del = new DeleteAction(out);
        Input input = mock(Input.class);
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===="
                + ln + "Ошибка удаления заявки." + ln));
    }
}