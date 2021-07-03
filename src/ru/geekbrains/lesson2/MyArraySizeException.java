package ru.geekbrains.lesson2;

public class MyArraySizeException extends Exception  {

    public MyArraySizeException(String message) {
         super (message);
    }

    public MyArraySizeException() {
        super("Размер массива не соответствует 4х4");
    }
}
