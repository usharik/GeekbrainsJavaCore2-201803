package ru.geekbrains.lesson2;

public class Main {

    public static void main(String[] args){

        String[][] arrStr = new String[4][3];
        int m = 10;
        for (int i = 0; i < arrStr.length; i++){
            for (int j = 0; j < arrStr[i].length; j ++){
                arrStr[i][j] = "-" + m + ".5r";
                m++;
                System.out.print(arrStr[i][j] + " ");
            }
            System.out.println();
        }
        try{
            double result = MyArray.getArray(arrStr);
            System.out.println(result);
        }
        catch(MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
        catch(MyArraySizeException ex){
            System.out.println(ex.getMessage());

        }
    }
}
