package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    private String name;

    public Robot(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.isOnDistance = true;
        this.runDistance = runDistance;
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
        System.out.println(String.format("Робот %s пробежал кросс длинной %d", name, distance));
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
        System.out.println(String.format("Робот %s пругнул на высоту %d", name, height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Робот не умеет плавать");
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}
