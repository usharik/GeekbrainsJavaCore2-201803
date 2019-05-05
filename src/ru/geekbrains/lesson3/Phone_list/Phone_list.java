package ru.geekbrains.lesson3.Phone_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Phone_list {
    private HashMap<String, HashSet<Long>> phone_list;

    public Phone_list(){
        HashSet<Long> phone1 = new HashSet<>();
        this.phone_list = new HashMap<>();
        phone1.add(1245789857L);
        phone1.add(1117854712L);
        phone1.add(1554721869L);
        phone_list.put("Иванов", phone1);
        HashSet<Long> phone2 = new HashSet<>();
        phone2.add(9070896966L);
        phone2.add(9647436346L);
        phone_list.put("Сидоров", phone2);
        System.out.println(phone_list);
    }

    public void Add_phone(Long phone, String surname){
        HashSet<Long> phones = phone_list.getOrDefault(surname, new HashSet<>());
        System.out.println(phones);
        phones.add(phone);
        phone_list.put(surname, phones);
        PrintRes();
        /*boolean is_finded = false;
        boolean already_in = false;
        HashSet<Long> phones;
        Iterator<HashMap.Entry<String, HashSet<Long>>> entries = phone_list.entrySet().iterator();
        while (entries.hasNext()) {
            HashMap.Entry<String, HashSet<Long>> entry = entries.next();
            if (entry.getKey() == surname){
                is_finded = true;
                for (Long p : entry.getValue())
                if (p == phone){
                    already_in = true;
                    break;
                }
                break;
            }
        }

        if (already_in){
            System.out.println(String.format("Телефон %l  для клиента %s уже существует.", phone, surname));
        }
        else if (is_finded){
            phones = new HashSet<>(phone_list.get(surname));
            phones.add(phone);
            phone_list.put(surname, phones);
        }
        else{
            phones = new HashSet<>();
            phones.add(phone);
            phone_list.put(surname, phones);
        }
        PrintRes();
        //System.out.println(phone_list);*/
    }

    public void Get_phone(String surname){
        if (phone_list.containsKey(surname)){
            System.out.println(surname + ": " + phone_list.getOrDefault(surname, new HashSet<>()));
        }
        else {
            System.out.println("Такого пользователя не существует!");
        }
        /*System.out.println("Результат поиска для '" + surname + "':");
        boolean is_finded = false;

        Iterator<HashMap.Entry<String, HashSet<Long>>> entries = phone_list.entrySet().iterator();
        while (entries.hasNext()) {
            HashMap.Entry<String, HashSet<Long>> entry = entries.next();
            /*if (surname.toLowerCase().equals(entry.getValue().toLowerCase())){
                System.out.println(entry.getKey());
                is_finded = true;
            }
        }
        if (!is_finded){
            System.out.println("Телефоны не найдены!");
        }*/
    }

    private void PrintRes(){
        System.out.println("----------------------------------------");
        Iterator<HashMap.Entry<String, HashSet<Long>>> entries = phone_list.entrySet().iterator();
        while (entries.hasNext()) {
            HashMap.Entry<String, HashSet<Long>> entry = entries.next();
            System.out.println(entry.getKey() + ": " + phone_list.get(entry.getKey()));
        }
    }
}
