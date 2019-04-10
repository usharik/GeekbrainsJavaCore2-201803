package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Wall extends Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Participant participant) {
        participant.jump(this.height);
    }
}
