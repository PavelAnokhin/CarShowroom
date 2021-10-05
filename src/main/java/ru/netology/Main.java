package ru.netology;

public class Main {

    public static void main(String[] args) {
        final Shop shop = new Shop();
        for(int i=0; i<4; i++) {
            new Thread(null, shop::sellCar, "Покупатель авто " + i).start();
            new Thread(null, shop::recieveCar, "Автосалон").start();
        }
    }
}
