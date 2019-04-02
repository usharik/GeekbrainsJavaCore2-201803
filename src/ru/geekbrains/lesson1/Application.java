package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.Cat;
import ru.geekbrains.lesson1.animal.Dog;
import ru.geekbrains.lesson1.animal.Human;
import ru.geekbrains.lesson1.animal.Robot;
import ru.geekbrains.lesson1.course.*;
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
                new Water(5),
                new Speach()
        );

        Team team = new Team(course.getNumOfObstacles(),
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Cat("Мурка", Color.WHITE, 1, 80, 7),
                new Dog("Шарик", Color.YELLOW, 3, 150, 2),
                new Human("Василий", Color.RED, 15, 90, 3),
                new Robot("R2-D2", 200, 10)
        );



        course.doIt(team);
        team.showResults();
    }
}
