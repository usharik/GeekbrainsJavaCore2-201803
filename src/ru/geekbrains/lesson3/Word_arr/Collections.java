package ru.geekbrains.lesson3.Word_arr;

import java.util.ArrayList;
import java.util.HashMap;

public class Collections {
    public static void main(String[] args) {
        String[] mass = {"cat", "pig", "dog", "dog", "horse", "mouse", "horse", "dog", "cat", "eagle", "duck", "horse", "eagle", "bird", "cat", "pig", "rabbit", "fish", "dog", "cat"};
        ArrayList<String> arr_list = new ArrayList<>();
        HashMap<String, Integer> hash_map = new HashMap<>();
        for(String el : mass){
            hash_map.put(el, (hash_map.get(el) == null) ? 1 : hash_map.get(el) + 1);
        }
        for (HashMap.Entry<String, Integer> entry : hash_map.entrySet()) {
            if (entry.getValue() == 1){
                arr_list.add(entry.getKey());
            }
        }
        System.out.println("Уникальные значения: " + arr_list);
        System.out.println(hash_map);
    }
}
