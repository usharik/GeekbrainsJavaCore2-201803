package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Cat extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

/*    public Cat(String name, Color color) {
        super(name, color, 0);
    }*/

    @Override
    public void voice() {
        System.out.println("мяу");
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
        System.out.println(String.format("Кошка %s пробежала кросс длиной %d", getName(), distance));
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
        System.out.println(String.format("Кошка %s прыгнула на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println(String.format("Кошка %s не умеет плавать ", getName()));
        // throw new UnsupportedOperationException("Кошка не умеет плавать");
    }

    @Override
    public void podium(){
        System.out.print(String.format("Кошка %s цвета %s прошла дистанцию\nдо конца и радостно заявляет: ", getName(), getColor().getName()));
        voice();
        System.out.println(" ");
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}
