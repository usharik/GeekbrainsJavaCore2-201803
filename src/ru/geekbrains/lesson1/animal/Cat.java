package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Animals;
import ru.geekbrains.lesson1.enums.Color;

public class Cat extends Animal {


    public Cat(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(Animals.CAT, name, color, age, true, runDistance, jumpHeight);
    }


    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    @Override
    public void swim(int distance) {
        super.setOnDistance(false);
        System.out.println("Кошка не умеет плавать");
        // throw new UnsupportedOperationException("Кошка не умеет плавать");
    }

}
