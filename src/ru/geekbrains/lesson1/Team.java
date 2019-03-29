package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Human;
import ru.geekbrains.lesson1.animal.Robot;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;
    private String nameTeam;

    // здесь используется конструктор с переменным числом параметров
    public Team(String nameTeam, Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.nameTeam = nameTeam;
        this.participants = participants;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void participantsInfo() {//todo
        System.out.println("Состав команды " + nameTeam);
        System.out.println("-----------------------------------------");
        for (Participant participant : participants) {
            if(participant instanceof Cat) {
                System.out.println("Кошка " + ((Cat) participant).getName() + " " + ((Cat) participant).getColor().getName() +
                        " цвет с возрастом " + ((Cat) participant).getAge());
            }
            if(participant instanceof Dog) {
                System.out.println("Собака " + ((Dog) participant).getName() + " " + ((Dog) participant).getColor().getName() +
                        " цвет с возрастом " + ((Dog) participant).getAge());
            }
            if(participant instanceof Human) {
                System.out.println("Человек " + ((Human) participant).getName() + " " + ((Human) participant).getColor().getName() +
                        " цвет с возрастом " + ((Human) participant).getAge());
            }
            if(participant instanceof Robot) {
                System.out.println("Робот " + ((Robot) participant).getName() + " " + ((Robot) participant).getColor().getName() + " цвет" );
            }
        }
        System.out.println("-----------------------------------------");
    }

    public void finishersInfo() { //todo
        System.out.println("Прошли препятствия из команды " + nameTeam);
        System.out.println("-----------------------------------------");
        for (Participant participant : participants) {
            if(participant.isOnDistance()) {
                if(participant instanceof Cat) {
                    System.out.println("Кошка " + ((Cat) participant).getName() + " " + ((Cat) participant).getColor().getName() +
                            " цвет с возрастом " + ((Cat) participant).getAge());
                }
                if(participant instanceof Dog) {
                    System.out.println("Собака " + ((Dog) participant).getName() + " " + ((Dog) participant).getColor().getName() +
                            " цвет с возрастом " + ((Dog) participant).getAge());
                }
                if(participant instanceof Human) {
                    System.out.println("Человек " + ((Human) participant).getName() + " " + ((Human) participant).getColor().getName() +
                            " цвет с возрастом " + ((Human) participant).getAge());
                }
                if(participant instanceof Robot) {
                    System.out.println("Робот " + ((Robot) participant).getName() + " " + ((Robot) participant).getColor().getName() + " цвет");
                }
            }
        }
        System.out.println("-----------------------------------------");
    }

}
