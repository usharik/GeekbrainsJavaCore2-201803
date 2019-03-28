package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Animals;
import ru.geekbrains.lesson1.enums.Color;

public abstract class Animal implements Participant {

    private String name;
    private Color color;
    private int age;
    private Animals typeAnimal;

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

     Animal(Animals typeAnimal, String name, Color color, int age, boolean isOnDistance, int runDistance, int jumpHeight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.isOnDistance = isOnDistance;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.typeAnimal = typeAnimal;
    }

    public Animal(String name, Color color, int age, boolean isOnDistance, int runDistance, int jumpHeight) {
        this(Animals.TBD, name, color, age, isOnDistance, runDistance, jumpHeight);
    }

    // Перегруженный (overload) конструктор
//    public Animal(String name, Color color) {
//        this(name, color, 0);
//        this.name = name;
//        this.color = color;
//        this.age = 0;
//    }

    public abstract void voice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void setOnDistance(boolean onDistance) {
        isOnDistance = onDistance;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
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
            System.out.println(String.format("%s %s Не осилил%s кросс длинной %d", typeAnimal.getTypeAnimal(), name, typeAnimal.getEnding(), distance));
            return;
        }
        System.out.println(String.format("%s %s пробежал%s кросс длинной %d", typeAnimal.getTypeAnimal(), name, typeAnimal.getEnding(), distance));

    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("%s %s Не осилил%s высоту %d", typeAnimal.getTypeAnimal(), name, typeAnimal.getEnding(), height));
            return;
        }
        System.out.println(String.format("%s %s прыгнул%s на высоту %d", typeAnimal.getTypeAnimal(), name, typeAnimal.getEnding(), height));

    }

    @Override
    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            System.out.println(String.format("%s %s Не осилил%s заплыв на расстояние %d", typeAnimal.getTypeAnimal(), name, typeAnimal.getEnding(), distance));
            return;
        }
        System.out.println(String.format("%s %s проплыл%s на расстояние %d", typeAnimal.getTypeAnimal(), name, typeAnimal.getEnding(), distance));


    }

    @Override
    public void speak() {
        voice();
    }
}
