package ru.geekbrains.homework5;

public class Threads {

    static final int size = 10000000;
    static final int h = size / 2;

    private static synchronized void calc(float[] arr){

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void method1(float[] arr){

        long a = System.currentTimeMillis();
        System.out.println("Время начала выполния первого метода: " + a + " мс");

        calc(arr);

        System.out.println("Время выполнения первым методом: " + (System.currentTimeMillis() - a) + " мс");

    }

    private static void method2(float[] arr) throws InterruptedException {

        long a = System.currentTimeMillis();
        System.out.println("Время начала выполния второго метода: " + a + " мс");

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(a1);
            }
        });
        t1.start();
        t1.join();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(a2);
            }
        });
        t2.start();
        t2.join();


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);


        System.out.println("Время выполнения вторым методом: " + (System.currentTimeMillis() - a) + " мс");

    }

    public static void main(String[] args) throws InterruptedException {

        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        method1(arr);
        method2(arr);

    }
}

