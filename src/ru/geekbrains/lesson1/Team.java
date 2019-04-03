package ru.geekbrains.lesson1;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;
    private String nameTeam;

    public Team(String nameTeam, Participant... participants) {
        this.nameTeam = nameTeam;
        this.participants = participants;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void participantsInfo() {
        System.out.println("Состав команды " + nameTeam);
        System.out.println("-----------------------------------------");
        for (Participant participant : participants)
            participant.getInfo();
        System.out.println("-----------------------------------------");
    }

    public void finishersInfo() { //todo
        System.out.println("Прошли препятствия из команды " + nameTeam);
        System.out.println("-----------------------------------------");
        for (Participant participant : participants)
            if(participant.isOnDistance())
                participant.getInfo();
        System.out.println("-----------------------------------------");
    }

}
