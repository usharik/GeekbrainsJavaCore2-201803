package ru.geekbrains.lesson2;

public class Main {

    private static void checkArray(String[][] array) throws MyArrayDataException, MyArraySizeException {
        try {
            int x = 0;
            int y = 0;
            try {
                int sum = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array.length != 4)
                        throw new MyArraySizeException();
                    for (int j = 0; j < array[i].length; j++) {
                        if (array[i].length != 4) {
                            throw new MyArraySizeException();
                        }
                        int element = Integer.parseInt(array[i][j]);
                        sum += element;
                        x = i;
                        y = j;
                    }
                }
                System.out.println("Сумма элементов массива равна: " + sum + "\n");
            } catch (NumberFormatException ex) {
                throw new MyArrayDataException(x, y);
            }

        } catch (MyArraySizeException ex) {
            ex.printStackTrace();
            System.out.println();
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
            System.out.println();
        }
    }


    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {

        /*
          Создаем 3 строковых массива:
        */
        String[][] correctArray = new String[4][4];
        for (int i = 0; i < correctArray.length; i++) {
            for (int j = 0; j < correctArray[i].length; j++) {
                int counter = (int) (Math.random() * 10);
                correctArray[i][j] = String.format("%d", counter);
            }
        }

        String[][] wrongArray1 = new String[4][3];
        for (int i = 0; i < wrongArray1.length; i++) {
            for (int j = 0; j < wrongArray1[i].length; j++) {
                int counter = (int) (Math.random() * 10);
                wrongArray1[i][j] = String.format("%d", counter);
            }
        }

        String[][] wrongArray2 = new String[4][4];
        for (int i = 0; i < wrongArray2.length; i++) {
            for (int j = 0; j < wrongArray2[i].length; j++) {
                int counter = (int) (Math.random() * 10);
                wrongArray2[i][j] = String.format("%d", counter);
            }
        }
        wrongArray2[3][1] = "bug";

        /*
        выводим массивы в консоль
        */

        new ShowArray(correctArray);
        new ShowArray(wrongArray1);
        new ShowArray(wrongArray2);

        /*
        проверяем массивы на соответствие требованиям
        */

        checkArray(correctArray);
        checkArray(wrongArray1);
        checkArray(wrongArray2);
    }
}
