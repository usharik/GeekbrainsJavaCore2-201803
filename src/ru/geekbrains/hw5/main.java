package ru.geekbrains.hw5;

public class main {

    public static void main(String[] args){
        String i;
        threads_test t1 = new threads_test();
        i = t1.methodOne();
        System.out.println(i);
        System.out.println("----------------------------------------------------");
        threads_test t2 = new threads_test();
        i = t2.methodTwo();
        System.out.println(i);
    }

}
