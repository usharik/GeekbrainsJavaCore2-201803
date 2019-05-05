package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.course.Course;
import ru.geekbrains.lesson1.course.Cross;
import ru.geekbrains.lesson1.course.Wall;
import ru.geekbrains.lesson1.course.Water;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Класс для запуска приложения - симулятор кросса
 */
public class Application {

    public static void main(String[] args) {
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Dog("Шарик", Color.RED, 1, 80, 7),
                new Human("Петр", Color.BLACK, 2, 300, 8),
                new Robot("Валли", Color.YELLOW, 30, 8000, 700)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(10),
                new Cross(90),
                new Water(5)
        );

        course.doIt(team);

        team.showTeamInfo();
    }
}
