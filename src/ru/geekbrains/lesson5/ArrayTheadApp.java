package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ArrayTheadApp {
    static final int size = 10000000;

    private static void initArr(float[] arr) {
        for (int i = 0; i < arr.length; ) {
            arr[i] = ++i;
        }
    }

    private static float[] fillArrByFormula(float[] arr) {
        for (int t = 0; t < arr.length; t++) {
            int i = (int) arr[t];
            /**arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));*/
            arr[t] = (float) (1 * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    private static long first(float[] arr) {
        long a = System.currentTimeMillis();
        fillArrByFormula(arr);
        return System.currentTimeMillis() - a;
    }

    private static long second(float[] arr, int base) {

        final int noOfThreads = 2 * base;
        final int length = size / noOfThreads;
        final CountDownLatch executionCompleted = new CountDownLatch(noOfThreads);

        int srcPos = 0;
        long a = System.currentTimeMillis();
        List<float[]> parts = new ArrayList<>();

        for (int t = 0; t < noOfThreads; t++) {
            float[] dest = new float[length];

            System.arraycopy(arr, srcPos, dest, 0, length);
            srcPos += length;
            parts.add(dest);
        }

        for (int t = 0; t < noOfThreads; t++) {
            int finalT = t;
            new Thread(() -> {
                parts.set(finalT, fillArrByFormula(parts.get(finalT)));
                executionCompleted.countDown();
            }).start();
        }
        try {
            executionCompleted.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int destPos = 0;
        for (int t = 0; t < noOfThreads; t++) {
            System.arraycopy(parts.get(t), 0, arr, destPos, length);
            destPos += length;
        }
        return System.currentTimeMillis() - a;
    }

    public static void main(String[] args) {
        float[] arr = new float[size];
//        Arrays.fill(arr, 1);
        initArr(arr);
        System.out.printf("Первый метод: %d%n", first(arr));
//        System.out.println(arr[5000023]);
//        Arrays.fill(arr, 1);
        initArr(arr);
        System.out.printf("Второй метод (base = %d): %d%n", 1, second(arr, 1));
//        System.out.println(arr[5000023]);
//        Arrays.fill(arr, 1);
        initArr(arr);
        System.out.printf("Второй метод (base = %d): %d%n", 2, second(arr, 2));
//        System.out.println(arr[5000023]);
        initArr(arr);
        System.out.printf("Второй метод (base = %d): %d%n", 3, second(arr, 3));
//        System.out.println(arr[5000023]);
        initArr(arr);
        System.out.printf("Второй метод (base = %d): %d%n", 4, second(arr, 4));
//        System.out.println(arr[5000023]);

    }

}
