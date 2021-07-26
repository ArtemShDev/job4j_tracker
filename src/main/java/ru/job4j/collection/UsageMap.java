package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> accounts = new HashMap<String, String>();
        accounts.put("dev.art.balt@gmail.com", "Shmelev Artem Victorovich");
        accounts.put("dev.art.balt@gmail.com2", "Shmelev Artem Victorovich333");
        for (String key : accounts.keySet()) {
            System.out.println(accounts.get(key));
        }
    }
}
