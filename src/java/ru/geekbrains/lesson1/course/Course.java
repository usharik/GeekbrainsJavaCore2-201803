package ru.geekbrains.lesson1.course;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.Team;

/**
 * Класс - полоса препятствий
 */
public class Course {

    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        System.out.println("На полосе препятствий команда " + team.getTeamName() + "\n");
        for (Participant participant : team.getParticipants()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);

                // если участник сошел с дистанции, то нет смысла двигать его дальше
                if (!participant.isOnDistance()) {
                    System.out.println("Участник сошел с дистанции");
                    break;
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}