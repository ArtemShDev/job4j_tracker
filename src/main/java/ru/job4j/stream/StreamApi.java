package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = List.of(-8,2,-15,3,9,-25);
        list = list.stream().filter(i -> i > 0).collect(Collectors.toList());
        list.forEach(System.out::println);
    }



}
