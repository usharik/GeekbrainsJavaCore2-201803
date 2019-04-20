package ru.geekbrains.lesson5;

import java.util.Arrays;

public class HomeWorkKulikova{
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static void calculate(float[] arr, int shift){
        for (int i = 0; i < arr.length; i++){
            int ix = i + shift;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + ix / 5) * Math.cos(0.2f + ix / 5)* Math.cos(0.4f + ix / 5));
        }
    }

    static void calculateSinglThread(float[] arr){
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        calculate(arr, 0);
        System.out.println(System.currentTimeMillis() - a);
    }

    static void calculateMultiThread (float[] arr) throws InterruptedException {
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        float[] firstArr = new float[HALF];
        float[] secondArr = new float[HALF];
        System.arraycopy(arr, 0, firstArr, 0, HALF);
        System.arraycopy(arr, HALF, secondArr, 0, HALF);

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                calculate(firstArr, 0);
            }
        });
        firstThread.start();

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                calculate(secondArr, HALF);
            }
        });
        secondThread.start();

        secondThread.join();
        firstThread.join();

        System.arraycopy(firstArr, 0, arr, 0, HALF);
        System.arraycopy(secondArr, 0, arr, HALF, HALF);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];

        calculateSinglThread(arr);
        calculateMultiThread(arr);
    }
}
