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
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + "; pages : " + books[i].getPage());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + "; pages : " + books[i].getPage());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals("Clean code")) {
                System.out.println(books[i].getTitle() + "; pages : " + books[i].getPage());
            }
        }
    }
}
