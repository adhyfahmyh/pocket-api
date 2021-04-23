package com.enigma.pocket.entity;

public class Engine {
    private String brand;
    private String name;
    private Car car;

    public Engine(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
