package ru.geekbrains.homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {

    private Map<String, List<String>> contacts = new HashMap<>();

    private void add(String name, String tel) {
        List<String> phoneNums = contacts.getOrDefault(name, new ArrayList<>());    //getOrDefault - честно подсмотрел у коллеги
        phoneNums.add(tel);
        contacts.put(name, phoneNums);
    }

    private List get(String name){
        return contacts.get(name);
    }


    public static void main(String[] args) {
        Contacts contacts = new Contacts();

        contacts.add("Иванов", "111-111-111");
        contacts.add("Петров", "222-222-222");
        contacts.add("Сидоров", "333-333-333");
        contacts.add("Иванов", "444-444-444");
        contacts.add("Иванов", "555-555-555");
        contacts.add("Петров", "666-666-666");

        System.out.println("Иванов: " + contacts.get("Иванов"));
        System.out.println("Петров: " + contacts.get("Петров"));
        System.out.println("Сидоров: " + contacts.get("Сидоров"));
    }
}
