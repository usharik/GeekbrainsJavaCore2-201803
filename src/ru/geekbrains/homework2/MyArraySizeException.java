package ru.geekbrains.homework2;

class MyArraySizeException extends Exception {
    MyArraySizeException(){
        super("Размер массива должен быть 4 на 4");
    }
}