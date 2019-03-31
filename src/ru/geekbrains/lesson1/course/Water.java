package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Water extends Obstacle {

    private int distance;

    public Water(int distance) {
        // TODO доработать по аналогии с другими препятствиями
        this.distance = distance;
    }

    @Override
    public void doIt(Participant participant) {
        // TODO доработать по аналогии с другими препятствиями
        participant.swim(this.distance);
    }
}
