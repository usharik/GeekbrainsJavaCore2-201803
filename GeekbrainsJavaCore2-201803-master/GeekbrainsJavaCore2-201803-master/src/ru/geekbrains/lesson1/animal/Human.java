package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Human extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int swimDistance;
    private int jumpHeight;

    public Human(String name, int age, int swimDistance, int runDistance, int jumpHeight) {
        super(name, "none", age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpHeight = jumpHeight;
    }
    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("%s пробежал(а) кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("%s прыгнул(а) на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > swimDistance) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("%s проплыл(а) %d метров", getName(), distance));
    }

    @Override
    public void voice() {
        System.out.println("Hello");
    }
}
