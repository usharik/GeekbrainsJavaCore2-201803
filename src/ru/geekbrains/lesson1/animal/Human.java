package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Human extends Animal implements Participant {

    private boolean isOnDistance;

    public Human(String name, Color color, int age) {
        super(name, color, age);
    }

    public Human(String name, Color color) {
        super(name, color, 0);
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance; // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void run(int distance) {
        // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void jump(int height) {
        // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void swim(int distance) {
        // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void voice() {
        // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void getResult() {
        System.out.println(String.format("Кошка %s %sпрошла полосу препятствий",
                getName(), isOnDistance ? "" : " не"));
    }
}
