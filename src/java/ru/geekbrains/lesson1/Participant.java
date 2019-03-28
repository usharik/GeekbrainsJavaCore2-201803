package ru.geekbrains.lesson1;

/**
 * Интерфейс - участник соревнований
 */
public interface Participant {

    boolean isOnDistance();

    void isFinish();

    String getName();

    void run(int distance);

    void jump(int height);

    void swim(int distance);


}