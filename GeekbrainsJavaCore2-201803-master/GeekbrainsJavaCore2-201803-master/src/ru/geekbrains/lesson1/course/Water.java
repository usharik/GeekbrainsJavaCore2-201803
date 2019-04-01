package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Water extends Obstacle {

    private int swimDistance;

    public Water(int distance) {
            this.swimDistance = distance;
    }

    @Override
    public void doIt(Participant participant) {
        {
            participant.swim(this.swimDistance);
    }
}
