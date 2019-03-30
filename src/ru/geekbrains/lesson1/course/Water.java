package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Water extends Obstacle {

    private int pooldist;

    public Water(int pooldist) {
        this.pooldist = pooldist;
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(this.pooldist);
    }
}
