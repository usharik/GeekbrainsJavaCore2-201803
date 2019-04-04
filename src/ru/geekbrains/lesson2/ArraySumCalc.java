package ru.geekbrains.lesson2;

/**
 * 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 *
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
 *
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
 *
 * Несколько комментариев.
 * 1. Для всех упомянутые в тексте задания исключений вам нужно будет самим создать классы
 * 2. Предлагаю сделать их checked, чтобы лучше разобраться с этой особенностью языка
 * 3. Для этого задания я не даю основы, как для прошлого.
 */

public class ArraySumCalc {
    public static int calcSumArray(String[][] inArray) throws MyArraySizeException, MyArrayDataException {
        int sumArray = 0;

        if (inArray.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i].length != 4) {
                throw new MyArraySizeException();
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
                //, {"9", "10", "11", "12"}
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
