package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            int numberLeft = Integer.parseInt(left.split("\\.")[0]);
            int numberRight = Integer.parseInt(right.split("\\.")[0]);
            int rsl = Integer.compare(numberLeft, numberRight);
            if (rsl != 0) {
                return rsl;
            }
        }
        return left.length() - right.length();
    }
}