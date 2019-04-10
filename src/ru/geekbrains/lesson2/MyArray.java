package ru.geekbrains.lesson2;


import java.text.NumberFormat;

class MyArray{

    final private static int SIZE_ARR = 4;

    public static double getArray(String[][] numArr) throws MyArraySizeException, MyArrayDataException{
        int i;
        double result = 0;
        String vvv;
        NumberFormat nf = NumberFormat.getInstance();

        if (numArr.length != SIZE_ARR) throw new MyArraySizeException("строк", SIZE_ARR);
        for (i = 0; i < numArr.length; i ++){
            if (numArr[i].length != SIZE_ARR) throw new MyArraySizeException("столбцов", SIZE_ARR);
        }

        for (i = 0; i < numArr.length; i++){
            for (int j = 0; j < numArr[i].length; j ++){
                vvv = numArr[i][j];
                /*if (nf.parse(vvv))  { //numArr[i][j] == null || !numArr[i][j].matches("^[-+]?[0-9]*[.,]?[0-9]+$")) {
                    result += Double.parseDouble(numArr[i][j].replace(',','.'));
                }
                else throw new MyArrayDataException(numArr[i][j], i, j);*/
                try{
                    result += Double.parseDouble(numArr[i][j].replace(',','.'));
                }
                catch(NumberFormatException  e){
                    throw new MyArrayDataException(numArr[i][j], i, j);
                }
            }

        }
        return result;
    }
}

