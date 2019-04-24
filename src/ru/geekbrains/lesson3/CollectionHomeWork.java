package ru.geekbrains.lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CollectionHomeWork {
    public static void main(String[] args) {
        String [] wordArray = {"coin", "coin", "coin", "apple", "cat", "summer", "wind", "summer", "cat", "dog", "dove", "money", "north","dust", "dust", "north", "cold", "rain"};
        HashSet<String> hs = new HashSet<>();
        for(String o : wordArray){
            hs.add(o);
        }
        System.out.println(hs);

        HashMap<String, Integer> hm = new HashMap<>();
        Integer count = 0;

        for (String o : wordArray){
            count = hm.get(o);
            if(count == null){
                hm.put(o, 1);
            } else {
                hm.put(o, count+1);
            }
        }

        System.out.println(hm);

        Contacts contacts = new Contacts();

        contacts.addContact("Ivanov", "89123214334");
        contacts.addContact("Petrov", "88913576884");
        contacts.addContact("Klimov", "89265344774");
        contacts.addContact("Petrov", "89264756767");
        contacts.addContact("Ivanov", "89129008989");

        contacts.printContact("Ivanov");
        contacts.printContact("Petrov");


    }
}
