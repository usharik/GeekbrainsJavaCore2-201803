package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Animal;
import ru.geekbrains.lesson1.animal.Cat;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    String name;

    private Participant[] participants;

    // здесь используется конструктор с переменным числом параметров
    public Team(String name, Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
        this.name = name;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void showResults() {
        System.out.println("Результаты для команды " + '"' + name + '"' + ":");
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }
}
