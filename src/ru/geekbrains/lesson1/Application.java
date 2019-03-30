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
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 15),
                new Cat("Барсик Второй", Color.BLACK, 1, 80, 7),
                new Dog("Виталик", Color.RED, 2, 99, 20, 17),
                new Dog("Сема", Color.WHITE, 7, 89, 15, 18),
                new Human("Василий", Color.BROWN, 33, 90, 23, 22),
                new Robot("Бобот",Color.GRAY,999,10,30)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(10),
                new Cross(90),
                new Water(15),
                new Podium()
        );

        System.out.println("Прямая текстовая трасляция с соревнований:");
        System.out.println(" ");

        course.doIt(team);

        //team.showResults();

    }
}
