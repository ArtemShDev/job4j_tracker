package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 560);
        Book book2 = new Book("Learning Java", 860);
        Book book3 = new Book("Trash code", 100);
        Book book4 = new Book("Evgeny Onegin", 360);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book iBook : books) {
            System.out.println(iBook.getTitle() + "; pages : " + iBook.getPage());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book iBook : books) {
            System.out.println(iBook.getTitle() + "; pages : " + iBook.getPage());
        }
        for (Book iBook : books) {
            if ("Clean code".equals(iBook.getTitle())) {
                System.out.println(iBook.getTitle() + "; pages : " + iBook.getPage());
            }
        }
    }
}
