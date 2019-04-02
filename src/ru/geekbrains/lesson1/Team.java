package ru.geekbrains.lesson1;

import java.util.Arrays;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;
    private int[][] results;

    // здесь используется конструктор с переменным числом параметров
    public Team(int numOfObstacles, Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
        this.results = new int [participants.length][numOfObstacles];
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void addResult(int indexParticipant, int indexObstacle, int result){
        results[indexParticipant][indexObstacle] = result;
    }

    public void showResults(){
        System.out.println(Arrays.deepToString(results));
    }
}
