package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Compare " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        List<String> list = Arrays.asList(
                "FI",
                "Func Inter",
                "Lambda"
        );
        list.sort(cmpDescSize);
        System.out.println(list);
    }
}
