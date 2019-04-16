package ru.geekbrains.homework3;

import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addPhone(String name, String phone) {
        // Set<String> phones = phoneBook.computeIfAbsent(name, key -> new HashSet<>());
        Set<String> phones = phoneBook.get(name);
        if (phones == null) {
            phones = new HashSet<>();
            phoneBook.put(name, phones);
        }
        phones.add(phone);
    }

    public Set<String> getPhonesByName(String name) {
        return phoneBook.get(name);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPhone("Иванов", "9981571");
        phoneBook.addPhone("Иванов", "8267919");
        phoneBook.addPhone("Сидоров", "5454860");
        phoneBook.addPhone("Сидоров", "8763540");

        System.out.println(phoneBook.getPhonesByName("Иванов"));
        System.out.println(phoneBook.getPhonesByName("Сидоров"));

        Map<int[], int[]> intArrMap = new HashMap<>();
        Map<List<Integer>, Integer> mapList = new HashMap<>();

        intArrMap.put(new int[] { 1, 2 }, new int[] { 2, 1 });
        System.out.println(intArrMap.get(new int[] { 1, 2 }));

        mapList.put(Arrays.asList(1, 2), 1);
        System.out.println(mapList.get(Arrays.asList(1, 2)));
    }
}