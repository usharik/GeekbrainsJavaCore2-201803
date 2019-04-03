package ru.geekbrains.lesson2;

public class MyArray {
    public static void main(String[] args) {

        String [][] arr = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                            {"a", "10", "11", "12"}, {"13", "14", "15", "16"}};//MyArrayDataException

        String [][] arr1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15"}};//MySizeArrayException

        try {
            System.out.println("Сумма массива = " + sumArray(arr1));
        } catch (MySizeArrayException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    private static int sumArray(String [][] arr) throws MySizeArrayException, MyArrayDataException {
       if(arr.length != 4)
           throw new MySizeArrayException();

       int sum = 0;

       for (int i = 0; i < arr.length; i++) {
           if(arr[i].length != 4)
               throw new MySizeArrayException();
           for (int j = 0; j < arr[i].length; j++) {
               try {
                   sum += Integer.parseInt(arr[i][j]);
               } catch (NumberFormatException ex) {
                   throw new MyArrayDataException(i, j);
               }
           }
       }
       return sum;
    }
}
