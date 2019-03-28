package ru.geekbrains.lesson1.enums;

public enum Animals {
    CAT("Кошка", "а"),
    DOG("Собака", "а"),
    HUMAN("Человек", ""),
    TBD("Неизвестное животное", "о");

    private String typeAnimal;
    private String ending;

    Animals(String typeAnimal, String ending) {
        this.typeAnimal = typeAnimal;
        this.ending = ending;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public String getEnding() {
        return ending;
    }
}
