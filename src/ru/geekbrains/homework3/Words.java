package ru.geekbrains.homework3;

import java.util.*;

public class Words {
    public static void main(String[] args) {

        String[] words = {"конь", "сова", "еж", "волк", "белка", "еж", "сова", "сова",
                "лось", "медведь", "лиса", "конь", "уж", "кабан", "лиса"};

        List<String> wordsList = Arrays.asList(words);

        Set<String> wordsSet = new HashSet<>();
        wordsSet.addAll(wordsList);

        List<String> sortedList = new ArrayList<>(wordsSet);
        java.util.Collections.sort(sortedList);

        System.out.println("Коллекция уникальных слов в алфавитном порядке: " + sortedList);


        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsMap.containsKey(wordsList.get(i)))
                wordsMap.put(wordsList.get(i), wordsMap.get(wordsList.get(i)) + 1);
            else
                wordsMap.put(wordsList.get(i), 1);
        }

        System.out.println("Количество повторенений в коллекции: " + wordsMap);
    }
}