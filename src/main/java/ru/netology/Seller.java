package ru.netology;

public class Seller {
    private Shop shop;
    final int deliveryTime = 1000;
    final int waitingTime = 500;

    public Seller(Shop shop) {
        this.shop = shop;
    }


    public void recieveCar() {
        try {
            Thread.sleep(deliveryTime);
            synchronized (this){
                System.out.println("Автомобили разгружаются в магазине");
                shop.getNewCars().add(new Car());
                notify();
            }
            System.out.println("Автомобили поступили в салон");

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public Car sellCar () {
        System.out.println(Thread.currentThread().getName() + "  хотел бы приобрести новый автомобиль  ");
        synchronized (this) {
            try {
                Thread.sleep(waitingTime);
                if (shop.getNewCars().isEmpty()) {
                    System.out.println("Автомобили временно отсутствуют в салоне.");
                    wait();
                }
                System.out.println("Новый автомобиль купил  " + Thread.currentThread().getName());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            return shop.getNewCars().remove(0);
        }
    }
}
