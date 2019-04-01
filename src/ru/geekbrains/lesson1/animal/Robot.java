package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private String name;
    private Color color;

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Robot(String name, Color color, int runDistance, int jumpHeight, int swimDistance) {
        this(name, color);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance  = swimDistance;
    }

    public Robot(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
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
        System.out.println(String.format("Робот %s проплыл на длину %d", getName(), distance));
    }

    @Override
    public void getInfo() {
        System.out.println("Робот " + this.getName() + " " + this.getColor().getName() + " цвет" );
    }
}
