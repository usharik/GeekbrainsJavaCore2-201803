package ru.geekbrains.lesson3.Phone_list;

public class Phones {
    public static void main(String[] args){
        Phone_list phones = new Phone_list();
        phones.Add_phone(78945681212L, "Гришин");
        phones.Add_phone(99856547021L, "Вербицкий");

        phones.Get_phone("Романов");
        phones.Get_phone("Власов");
        phones.Get_phone("Гришин");
    }
}
