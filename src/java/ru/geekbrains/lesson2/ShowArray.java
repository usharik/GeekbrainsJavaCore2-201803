package ru.geekbrains.lesson2;

public class ShowArray {

    public ShowArray(String[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
