package ru.geekbrains.lesson2;


class MyArray{

    final private static int SIZE_ARR = 4;

    public static double getArray(String[][] numArr) throws MyArraySizeException, MyArrayDataException{
        int i;
        int status;
        double result = 0;

        if (numArr.length != SIZE_ARR) throw new MyArraySizeException("строк", SIZE_ARR);
        for (i = 0; i < numArr.length; i ++){
            if (numArr[i].length != SIZE_ARR) throw new MyArraySizeException("столбцов", SIZE_ARR);
        }

        for (i = 0; i < numArr.length; i++){
            for (int j = 0; j < numArr[i].length; j ++){
                if (numArr[i][j] == null || !numArr[i][j].matches("^[0-9]*[.,]?[0-9]+$")) status = 0;
                else status = 1;
                /*try {
                    Integer.parseInt(numArr[i][j]);
                    status = 1;
                } catch (Exception e) {
                    status = 0;
                }*/

                if (status == 1){//isNumber(numArr[i][j])){
                    result += Double.parseDouble(numArr[i][j].replace(',','.'));
                }
                else throw new MyArrayDataException(numArr[i][j], i, j);
            }
        }
        return result;
    }
}

