package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;

    // здесь используется конструктор с переменным числом параметров
    public Team(Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
          }

    public Participant[] getParticipants() {
        return participants;
    }


/*    public void showResults(){
        for (int i = 0; i < getParticipants().length; i++) {
            System.out.println(getParticipants()[i]);
        }
    }
    */
}
