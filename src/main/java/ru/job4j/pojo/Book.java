package ru.job4j.pojo;

public class Book {
    private String title;
    private int page;

    public Book(String title, int page) {
        this.page = page;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
