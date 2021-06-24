package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    /*public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Ни одной заявки не найдено");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id (for replace): ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the name (for create a new item): ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("=== The operation was successful ====");
                } else {
                    System.out.println("=== The operation was unsuccessful ====");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter item's id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("=== The deletion operation was successful ====");
                } else {
                    System.out.println("=== The deletion operation was unsuccessful ====");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter item's id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter the name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }*/
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select != 6) {
                System.out.println("Пользователь выбрал: " + select);
            } else {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
