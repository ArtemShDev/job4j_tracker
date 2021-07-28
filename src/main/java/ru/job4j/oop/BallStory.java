package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hear = new Hare();
        Wolf wolf = new Wolf();
        Fox fox   = new Fox();
        ball.roll();
        hear.tryEat(ball);
        ball.roll();
        wolf.tryEat(ball);
        ball.roll();
        fox.eat(ball);
    }
}
