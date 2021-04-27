package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Car;
import com.enigma.pocket.entity.Engine;
import com.enigma.pocket.format.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coba {
    @GetMapping("/coba")
    public ResponseEntity<ResponseMessage> getCar(){
        Engine twoJz = new Engine("toyota", "2jz");
        Car supra = new Car("Supra", 234, "black", twoJz);
        return ResponseEntity.accepted().body(ResponseMessage.commonResponse(200,supra));
    }
}
