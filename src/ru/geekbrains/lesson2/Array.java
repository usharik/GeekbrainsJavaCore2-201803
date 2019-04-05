package ru.geekbrains.lesson2;

public class Array {
    public static void main(String[] args) {
        String [][] array = {{"2", "1", "3", "three"}, {"3","2","1","two"}};

        try {
            System.out.println(sumArray(array));
        } catch (MyArrayDataException e){
            e.printStackTrace();
        } catch (MyArraySizeException e){
            e.printStackTrace();
        }

    }

    static int sumArray(String[][]arr) throws MyArraySizeException, MyArrayDataException{

        int sumArray = 0;
        int a = 0;
        int b = 0;
        int c = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException();
                }
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].length != 4) {
                        throw new MyArraySizeException();
                    }
                    try {
                        a = Integer.valueOf(arr[i][j]);
                        sumArray += a;
                        b = i;
                        c = j;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(b, c);
                    }

                }
            }

        return sumArray;
    }
}
