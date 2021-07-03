package ru.geekbrains.lesson3;

import java.util.*;

/**
 * Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneBook {
    Map<String, Set<String>> book = new HashMap<>();


    public Set<String> get(String key) {
        Set<String> result = new LinkedHashSet<>();
        if (book.containsKey(key)) {
            result = book.get(key);
        }

        return (result);
    }

    public void add(String key, String value) {
        Set<String> setToAdd = new LinkedHashSet<>();
        setToAdd = get(key);

        setToAdd.add(value);
        book.put(key, setToAdd);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "book=" + book +
                '}';
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "000-00-01");
        phoneBook.add("Иванов", "000-00-02");
        phoneBook.add("Петров", "000-01-01");
        phoneBook.add("Иванов", "000-02-02");
        phoneBook.add("Петров", "000-00-01");


        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Петров"));
    }

}
