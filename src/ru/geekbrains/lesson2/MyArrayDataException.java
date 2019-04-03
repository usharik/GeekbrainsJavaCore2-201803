package ru.geekbrains.lesson2;

public class MyArrayDataException extends Exception {
    MyArrayDataException(int row, int column) {
        super(String.format("Некорректное значение в ячейки %d %d", row, column));
    }
}
