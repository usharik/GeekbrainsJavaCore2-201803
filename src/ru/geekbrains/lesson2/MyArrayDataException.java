package ru.geekbrains.lesson2;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i, int j){
        super("Не корректный формат элемента [" + i +"]" +"[" + j +"]" );
    }
}
