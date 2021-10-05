package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Shop   {
    Seller seller = new Seller(this);
    List <Car> newCars = new ArrayList<>(7);

    public Car sellCar() {
        return seller.sellCar();
    }


    public void recieveCar() {
        seller.recieveCar();
    }

    List<Car> getNewCars() {
        return newCars;
    }


}
