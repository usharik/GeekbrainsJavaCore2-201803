package ru.geekbrains.lesson2.exceptions;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("Некорректный размер массива");
    }
}
