package ru.geekbrains.lesson3;

import java.util.HashMap;
import java.util.HashSet;

public class Contacts {
    HashMap<String, HashSet<String >> contacts;

    public Contacts() {
        this.contacts = new HashMap<>();
    }

    public void addContact (String name, String tel){
       HashSet<String> telNum = contacts.getOrDefault(name, new HashSet<>());
       telNum.add(tel);
       contacts.put(name, telNum);
    }

    public void printContact(String name){
        System.out.println(name + " tel: " + contacts.get(name));
    }
}
