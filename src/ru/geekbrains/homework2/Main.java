package ru.geekbrains.homework2;

public class Main {

    private String [][] arr1 = {
            {"88","0","3","3"},
            {"0","34","3","2"},
            {"5","0","!x","84"},
            {"22","23","1","17"}
    };

    private String [][] arr2 = {
            {"88","3","1","5"},
            {"0","34",},
            {"5","0","1"}
    };

    private String [][] arr3 = {
            {"88","0","75","5"},
            {"0","34","3","3"},
            {"5","3","77","84"},
            {"1","23","2","17"}
    };


    private int sum (String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4 на 4");
        }
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    total += Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j,arr[i][j]);
                }
            }
        }
        return total;
    }


    private void printArr(String arr[][]){
        System.out.println("Массив:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) /*throws MyArraySizeException, MyArrayDataException*/ {

        Main arr = new Main();
        String[][] array = arr.arr1; //для того, чтобы ниже не приходилось менять имя массива
        arr.printArr(array);
        try{
            System.out.println("Сумма элементов массива = " + arr.sum(array));
        }catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();}
    }
}
