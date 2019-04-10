package ru.geekbrains.lesson3.hw;

import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addPhone(String name, String phone) {
        //Set<String> phones = phoneBook.computeIfAbsent(name, key -> new HashSet<>());
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

        phoneBook.addPhone("Man", "123");
        phoneBook.addPhone("Man", "234");
        phoneBook.addPhone("Man1", "1235");
        phoneBook.addPhone("Man1", "2346");

        System.out.println(phoneBook.getPhonesByName("Man"));
        System.out.println(phoneBook.getPhonesByName("Man1"));

        Map<int[], int[]> intArrMap = new HashMap<>();
        Map<List<Integer>, Integer> mapList = new HashMap<>();

        intArrMap.put(new int[] {1, 2}, new int[] {2, 1});
        System.out.println(intArrMap.get(new int[] {1, 2}));

        mapList.put(Arrays.asList(1, 2), 1);
        System.out.println(mapList.get(Arrays.asList(1, 2)));
    }
}
