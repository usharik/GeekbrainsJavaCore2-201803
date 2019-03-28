package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.*;
import ru.geekbrains.lesson1.course.*;
import ru.geekbrains.lesson1.enums.*;

/**
 * Класс для запуска приложения - симулятор кросса
 */
public class Application {

    public static void main(String[] args) {

        Team team = new Team("Super",
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Dog("Зубастик", Color.GRAY, 3, 150, 3, 10),
                new Human("Alex", 45, 100, 1, 10),
                new Robot("R2D2", 999, 999, 999)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(2),
                new Cross(90),
                new Water(5)
        );

        team.showInfo(team.getTeamName());

        course.doIt(team);

        team.showResults();
    }
}