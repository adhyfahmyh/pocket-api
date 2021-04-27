package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PocketRestController {
    @Autowired
    PocketService pocketService;

    @GetMapping("/pocket/{id}")
    public Pocket getPocketById(@PathVariable(name = "id") String id){
        return pocketService.findPocketById(id);
    }

    @PostMapping("/pocket")
    public void createNewPocket(@RequestBody Pocket pocket){
        pocketService.createPocket(pocket);
    }
}
