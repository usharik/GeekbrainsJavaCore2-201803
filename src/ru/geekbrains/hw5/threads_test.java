package ru.geekbrains.hw5;

public class threads_test {

    static final int SIZE = 10000000;
    static final int parts = SIZE / 2;
    float[] arr = new float[SIZE];

    public threads_test(){
        for (int i=0; i<SIZE; i++){
            arr[i]=1;
        }
    }

    public String methodOne(){
        long a = System.currentTimeMillis();
        //System.out.println(a);
        for (int i=0; i<SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        //System.out.println(b);

        //System.out.println("t=" + (b-a));
        return "время работы: " + ((b-a)/1000) + " секунд " + ((b-a)-((b-a)/1000)*1000) + " миллисекунд";
    }




    public String methodTwo(){
        int cnt_threads = 2;
        float[][] arr1 = new float[cnt_threads][parts];
        //System.out.println(a);
        long a = System.currentTimeMillis();
        for (int i = 0; i < cnt_threads ; i++) {
            System.arraycopy(arr, parts * i, arr1[i], 0, parts);
        }
        Thread[] threads = new Thread[cnt_threads];
        for (int i = 0; i < cnt_threads ; i++) {
            int start_i = parts * i;
            int num_th = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < parts; j++) {
                        arr1[num_th][j] = (float) (arr1[num_th][j] * Math.sin(0.2f + (start_i + j) / 5) * Math.cos(0.2f + (start_i + j) / 5) * Math.cos(0.4f + (start_i + j) / 2));
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < cnt_threads ; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < cnt_threads ; i++) {
            System.arraycopy(arr1[i], 0, arr, parts * i, parts);
        }

        long b = System.currentTimeMillis();


        //System.out.println(b);
        //System.out.println("t=" + (b-a));
        return "время работы: " + ((b-a)/1000) + " секунд " + ((b-a)-((b-a)/1000)*1000) + " миллисекунд";
    }
}
