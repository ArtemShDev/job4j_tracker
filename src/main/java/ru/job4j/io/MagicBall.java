package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        int answerNumber = new Random().nextInt(3);
        if (answerNumber == 0) {
            System.out.println("Да");
        } else if (answerNumber == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
    }
}
