package ru.geekbrains.lesson2;

import java.util.Scanner;

public class CalcApplication {

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            System.out.println("Введите первое число:");
            int num1 = scn.nextInt();

            System.out.println("Введите второе число:");
            int num2 = scn.nextInt();

            System.out.println("Введите операцию:");
            String operation = scn.nextLine();
            switch (operation) {
                default:
                    System.out.println("Некоректная операция:" + operation);
            }
        }
    }
}
