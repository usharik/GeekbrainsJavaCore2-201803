package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Water extends Obstacle {

    private int distance;

    public Water(int distance) {
        this.distance = distance; // TODO доработать по аналогии с другими препятствиями
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(this.distance);// TODO доработать по аналогии с другими препятствиями
    }
}
