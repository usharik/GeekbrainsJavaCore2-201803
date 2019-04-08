package ru.geekbrains.lesson2;

class MyArrayDataException extends Exception{

    public MyArrayDataException(String elem, int rowNum, int colNum){
        super(String.format("%s (строка - %d, столбец - %d): нечисловой тип элемента массива!", elem, rowNum + 1, colNum + 1));
    }
}
