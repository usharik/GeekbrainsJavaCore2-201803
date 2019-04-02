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
        int indexPart = 0;
        int indexObs = 0;
        for (Participant participant : team.getParticipants()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);

                // если участник сошел с дистанции, то нет смысла двигать его дальше
                if (!participant.isOnDistance()) {
                    team.addResult(indexPart,indexObs,0);
                    break;
                }
                team.addResult(indexPart,indexObs,1);
                indexObs++;
            }
            System.out.println();
            indexPart++;
            indexObs = 0;
        }
    }
    public int getNumOfObstacles(){
        return obstacles.length;
    }
}
