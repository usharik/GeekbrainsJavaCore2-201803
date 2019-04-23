package ru.geekbrains.lesson5.myhomework;

public class CountingArrayInThreads {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {

        float[] array = new float[SIZE];

        CountingSingleArray(array);

        CountingDoubleArray(array);

    }

    public static void CountingSingleArray(float[] array) {

        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);
    }

    public static void CountingDoubleArray(float[] array) {

        long a = System.currentTimeMillis();

        float[] array1 = new float[H];
        System.arraycopy(array, 0, array1, 0, H);

        float[] array2 = new float[H];
        System.arraycopy(array, H, array2, 0, H);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    array2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread2.start();

        System.arraycopy(array1, 0, array, 0, H);
        System.arraycopy(array2, 0, array, H, H);

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - a);
    }
}


