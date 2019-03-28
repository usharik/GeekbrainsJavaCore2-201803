package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Human;
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
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Dog("Барсик", Color.BLACK, 1, 80, 7),
                new Human("Барсик", Color.BLACK, 1, 80, 7),
                new Robot("Барсик", 80, 7)

        );

        Course course = new Course(
                new Cross(50),
                new Wall(10),
                new Cross(90),
                new Water(5)
        );

        course.doIt(team);
    }
}
