package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.enums.Color;

public class Dog extends Animal {

    public Dog(String name, Color color, int age, int maxRunDistance,
               int maxJumpHeight, int maxSwimDistance) {
        super(name, color, age, maxRunDistance, maxJumpHeight, maxSwimDistance);
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }
}