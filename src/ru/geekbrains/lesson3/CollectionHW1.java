package ru.geekbrains.lesson3;

import java.util.*;

/**
 * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */
public class CollectionHW1 {
    public static void main(String[] args) {
        String[] words = {"one", "two", "two", "three", "three", "three", "four", "four", "four", "four", "five", "five", "five", "five", "five"};
        Map<String, Integer> stringMap = new HashMap<>();
        for (String word : words) {
            Integer val = 1;
            if (stringMap.containsKey(word)) {
                val = stringMap.get(word) + 1;
            }
            stringMap.put(word, val);
        }
        System.out.println(stringMap.keySet());
        System.out.println(stringMap);
    }
}
