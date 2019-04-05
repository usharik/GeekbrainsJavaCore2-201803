package ru.geekbrains.homework2;

public class Main {

    private String [][] arr1 = {
            {"88","p","*","5"},
            {"0","34","3","x"},
            {"5","hi","1","84"},
            {"!!!","23",".","17"}
    };

    private String [][] arr2 = {
            {"88","p","*","5"},
            {"0","34",},
            {"5","hi","1"}
    };

    private String [][] arr3 = {
            {"88","0","0","5"},
            {"0","34","3","3"},
            {"5","3","1","84"},
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
                    throw new MyArrayDataException("не цифра");
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


    public static void main(String[] args) {

        Main arr = new Main();
        String[][] array = arr.arr1; //для того, чтобы ниже не приходилось менять код
        try {
            arr.printArr(array);
            System.out.println("Сумма элементов массива = " + arr.sum(array));
        }catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

}
