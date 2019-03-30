package ru.geekbrains.lesson1.enums;

public enum Color {
    WHITE("белый"),
    BLACK("черный"),
    BROWN("коричневый"),
    GRAY("серый"),
    YELLOW("желтый"),
    RED("рыжий");

    private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName()  {
        return name;
    }
}
