package ru.geekbrains.lesson1;

/**
 * Класс - комманда участников соревнований
 */


public class Team {

    private String teamName;

    private Participant[] participants;

    // здесь используется конструктор с переменным числом параметров
    public Team(String teamName, Participant... participants) {
        this.teamName = teamName;
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
    }

    public void showInfo(String team){
        System.out.println((String.format("Приветствуем участников соревнований от команды %s", team)));
        for (Participant participant : participants) {
            System.out.println(participant.getName());
        }
        System.out.println(" ");

    }

    public void showResults() {
        for (Participant participant : participants) {
            participant.isFinish();
        }
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public String getTeamName() {
        return teamName;
    }
}
