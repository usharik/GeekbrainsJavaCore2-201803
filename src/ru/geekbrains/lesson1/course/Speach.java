package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;

public class Speach extends Obstacle{
    @Override
    public void doIt(Participant participant) {
        participant.speak();
    }
}
