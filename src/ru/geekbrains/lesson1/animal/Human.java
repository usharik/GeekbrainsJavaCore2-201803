package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Animals;
import ru.geekbrains.lesson1.enums.Color;

public class Human extends Animal {

    public Human(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(Animals.HUMAN, name, color, age, true, runDistance, jumpHeight);
    }

    @Override
    public void voice() {
        System.out.println("Hi");
    }
}
