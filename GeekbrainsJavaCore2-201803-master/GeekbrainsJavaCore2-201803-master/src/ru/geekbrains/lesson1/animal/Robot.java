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
    private int swimDistance;
    private int jumpHeight;

    public Robot(String name) {
        this.name = name;
    }


    public Robot(String name, int swimDistance, int runDistance, int jumpHeight) {
        this.name = name;
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
        System.out.println(String.format("Робот %s пробежал кросс длинной %d", getName(), distance));
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
        System.out.println(String.format("Робот %s прыгнул на высоту %d", getName(), height));
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
        System.out.println(String.format("Робот %s проплыл %d метров", getName(), distance));
    }

    @Override
    public void voice() {
        System.out.println("H-E-L-L-O");
    }
}
