package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private String name;

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Robot(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Robot(String name) {
        this.name = name;
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
            System.out.println(String.format("Робот %s Не осилил кросс длинной %d", name, distance));
            return;
        }
        System.out.println(String.format("Робот %s пробежал кросс длинной %d", name, distance));

    }

    @Override
    public void jump(int height) {

        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("Робот %s Не осилил высоту %d", name, height));
            return;
        }
        System.out.println(String.format("Робот %s прыгнул на высоту %d", name, height));

    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Робот не умеет плавать");
    }

    public void setOnDistance(boolean onDistance) {
        isOnDistance = onDistance;
    }

    @Override
    public void speak() {
        System.out.println("#$%#$%@#$%^$");
    }
}
