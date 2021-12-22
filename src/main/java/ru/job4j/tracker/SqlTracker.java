package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.
                prepareStatement("insert into items(name)"
                        + " values (?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement ps = cn.
                prepareStatement("update items set name = ? where id = ?")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = cn.
                prepareStatement("delete from items where id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Item(resultSet.getString("name"), resultSet.getInt("id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items where name = ?")) {
            ps.setString(1, key);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Item(resultSet.getString("name"), resultSet.getInt("id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement ps = cn.prepareStatement("select * from items where id = ?")) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return new Item(resultSet.getString("name"), resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}