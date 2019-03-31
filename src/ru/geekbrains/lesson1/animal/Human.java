package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Human extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Human(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.isOnDistance = true;
    }

    public Human(String name, Color color, int age) {
        super(name, color, age);
    }

    public Human(String name, Color color) {
        super(name, color, 0);
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance; // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void run(int distance) {
        // TODO доработать по аналогии с классом Cat

        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Человек %s пробежала кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        // TODO доработать по аналогии с классом Cat
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Человек %s прыгнул на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        // TODO доработать по аналогии с классом Cat
        isOnDistance = false;
        System.out.println("Человек почему-то не умеет плавать");
    }

    @Override
    public String getParticipantName() {
        return this.getName();
    }

    @Override
    public void voice() {
        // TODO доработать по аналогии с классом Cat
        System.out.println("Привет");
    }
}
