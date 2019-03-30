package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Podium extends Obstacle {


    @Override
    public void doIt(Participant participant) {
        participant.podium();
    }
}