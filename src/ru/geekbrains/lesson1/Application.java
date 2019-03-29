package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Human;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Robot;
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

        Course course = new Course(
                new Cross(50),
                new Wall(2),
                new Cross(90),
                new Water(5)
        );

        Team team = new Team("Команда А",
                new Cat("Барсик", Color.BLACK, 3, 100, 3),
                new Dog("Бобик", Color.GRAY, 5, 100, 1, 20),
                new Human("Джон", Color.WHITE, 20, 100, 3, 25),
                new Robot("C-3PO", Color.YELLOW, 500, 10, 5)
                // TODO здесь должны быть участники всех видов (Cat, Dog, Human, Robot)
        );

        team.participantsInfo();

        course.doIt(team);

        team.finishersInfo();
    }
}
