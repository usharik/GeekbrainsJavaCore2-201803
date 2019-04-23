package ru.geekbrains.lesson3;

import java.util.*;

public class WordsArray {

    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();
        arrList.add("Дом");
        arrList.add("Собака");
        arrList.add("Машина");
        arrList.add("Компьютер");
        arrList.add("Яблоко");
        arrList.add("Программист");
        arrList.add("Чай");
        arrList.add("Блокнот");
        arrList.add("Дом");
        arrList.add("Машина");
        arrList.add("Фрукты");
        arrList.add("Клавиша");
        arrList.add("Окно");
        arrList.add("Стол");
        arrList.add("Фрукты");
        arrList.add("Блокнот");
        arrList.add("Фрукты");

        Set uniq = new HashSet<>();

        for (String word : arrList) {
            uniq.add(word);
        }

        System.out.println(uniq);

        Collections.sort(arrList);

        String word = (String) arrList.get(0);
        int count = 0;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) != word) {
                word = (String) arrList.get(i);
                System.out.println(String.format("Слово %s встречается %d раз(а)", arrList.get(i - 1), count));
                count = 1;
            } else count++;
        }
        System.out.print(String.format("Слово %s встречается %d раз(а)", arrList.get(arrList.size() - 1), count));

    }
}

