package ru.geekbrains.lesson2;

public class ArraySumCalc {
    public static int calcSumArray(String[][] inArray) throws MyArraySizeException, MyArrayDataException {
        int sumArray = 0;

        if (inArray.length != 4) {
            throw new MyArraySizeException("Размер массива не соответствует 4х4");
        }
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i].length != 4) {
                throw new MyArraySizeException("Размер массива не соответствует 4х4");
            }
            for (int j = 0; j < inArray[i].length; j++) {
                try {
                    sumArray += Integer.valueOf(inArray[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(String.format("Значение '%s' в ячейке [%d][%d] не является Integer", inArray[i][j], i, j));
                }

            }
        }

        return sumArray;
    }

    public static void main(String[] args) {
        String[][] array4x4 = {{"1", "2", "3", "4"}
                , {"5", "6", "7", "8"}
                , {"9", "10", "11", "12"}
                , {"13", "14", "15", "16"}};
        try {
            System.out.println(calcSumArray(array4x4));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


    }
}
