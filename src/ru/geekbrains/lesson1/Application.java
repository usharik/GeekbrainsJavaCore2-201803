package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Human;
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

        Team team = new Team("Команда удачи",
                new Cat("Пуська", Color.RED, 2, 45, 5, 0),
                new Dog("Жучка", Color.BLACK, 3, 35, 2, 1000),
                new Human("Ванька", Color.WHITE, 29, 100, 1, 1000),
                new Bender("Бэндер", Color.BROWN, 1000,10,10000)

        );

        Course course = new Course(
                new Cross(45),
                new Wall(2),
                new Cross(30),
                new Water(100)
        );

        course.doIt(team);
        team.showResults();
    }
}

