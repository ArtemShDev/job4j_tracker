package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item item_ = new Item("item_9");
        assertTrue(tracker.replace(item.getId(), item_));
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item_1");
        Item item2 = new Item("item_2");
        tracker.add(item);
        tracker.add(item2);
        assertThat(tracker.findAll(), is(List.of(item, item2)));
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item_1");
        Item item2 = new Item("item_2");
        tracker.add(item);
        tracker.add(item2);
        assertThat(tracker.findById(item.getId()), is(item));
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item_123");
        Item item2 = new Item("item_555");
        tracker.add(item);
        tracker.add(item2);
        assertThat(tracker.findByName(item.getName()), is(List.of(item)));
        assertThat(tracker.findByName(item2.getName()), is(List.of(item2)));
    }
}