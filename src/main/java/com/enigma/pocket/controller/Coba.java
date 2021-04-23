package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Car;
import com.enigma.pocket.entity.Engine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coba {
    @GetMapping("/coba")
    public Car getCar(){
        Engine twoJz = new Engine("toyota", "2jz");
        Car supra = new Car("Supra", 234, "black", twoJz);
        return supra;
    }
}
