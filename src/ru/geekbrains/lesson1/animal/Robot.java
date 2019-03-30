package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private boolean isOnDistance;
    private String name;
    private Color color;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;
    private void voice() {
        System.out.println("гррр-кххх");
    }

    public Robot(String name, Color color, int runDistance, int jumpHeight, int swimDistance) {
        this.name = name;
        this.color = color;
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
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
        System.out.println(String.format("Робот %s пробехал на колесиках кросс длиной %d", getName(), distance));
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
        System.out.println(String.format("Робот %s подрыгнул на пружине на высоту %d", getName(), height));
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
        System.out.println(String.format("Робот %s перепрыгнул водное припятсвие длиной %d", getName(), distance));
    }
    @Override
    public void podium(){
        System.out.print(String.format("Робот %s цвета %s прошел дистанцию\nдо конца и радостно заявляет: ", getName(), getColor().getName()));
        voice();
        System.out.println(" ");
    }
}
