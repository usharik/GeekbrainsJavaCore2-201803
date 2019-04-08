package ru.geekbrains.lesson2;



class MyArraySizeException extends Exception{

    public MyArraySizeException(String message, int size){
        super(String.format("В массиве количество %s не соответствует %d.", message, size));
    }
}

