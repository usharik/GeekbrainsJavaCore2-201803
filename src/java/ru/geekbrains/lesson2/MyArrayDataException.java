package ru.geekbrains.lesson2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j) {
        super(String.format("Неверный формат элемента с координатами (%d, %d) переданного массива!", i, j));
    }

}
