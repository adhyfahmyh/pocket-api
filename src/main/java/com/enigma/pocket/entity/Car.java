package com.enigma.pocket.entity;

public class Car {
    private String name;
    private Integer nopol;
    private String color;
    private Engine engine;

    public Car(String name, Integer nopol, String color, Engine engine) {
        this.name = name;
        this.nopol = nopol;
        this.color = color;
        engine.setCar(this);
        this.engine = engine;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNopol() {
        return nopol;
    }

    public void setNopol(Integer nopol) {
        this.nopol = nopol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
