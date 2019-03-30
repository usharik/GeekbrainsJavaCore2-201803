package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.enums.Color;

public class Bender implements Participant {

    private String name;
    private Color color;

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimLength;

    public Bender(String name, Color color, int runDistance, int jumpHeight, int swimLength) {
        this.name = name;
        this.color = color;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimLength = swimLength;
        this.isOnDistance = true;
    }

    public void voice(){
        System.out.println("Я захвачу мир!");
    }

    public boolean isOnDistance() {
        return isOnDistance;
    }

    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            System.out.println(name  + " не смог(ла) пробежать расстояние " + distance + "км.");
            return;
        }
        else {
            System.out.println(name  + " смог(ла) пробежать расстояние " + distance + "км.");
            return;
        }

    }

    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(name  + " не смог(ла) перепрыгнуть стену " + height + "м.");
            return;
        }
        else {
            System.out.println(name  + " смог(ла) перепрыгнуть стену " + height + "м.");
        }
    }

    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (swimLength == 0){
            isOnDistance = false;
            System.out.println(name + " не умеет плавать!");
        }
        else if(distance > swimLength){
            isOnDistance = false;
            System.out.println(name + " не проплыл(а)" + distance + "м.");
        }
        else {
            System.out.println(name + " проплыл(а)" + distance + "м.");
        }
    }

    @Override
    public String toString() {
        return name + (isOnDistance() ? " прош(ел/ла) соревнования!" : " не справил(ся/ась) с соревнованиями!");
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
